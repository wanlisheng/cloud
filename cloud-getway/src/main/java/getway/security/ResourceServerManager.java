package getway.security;

import base.constant.GlobalConstants;
import base.constant.SecurityConstants;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import getway.util.UrlPatternUtils;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 用来做对资源权限的判断
 * */
@Component
@RequiredArgsConstructor
@Slf4j
@ConfigurationProperties(prefix = "security")
public class ResourceServerManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Autowired
    private RedissonClient redissonClient;

    @Value("${spring.application.name}")
    private String applicationName;
    @Setter
    private List<String> ignoreUrls;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        if (request.getMethod() == HttpMethod.OPTIONS) { // 预检请求放行
            return Mono.just(new AuthorizationDecision(true));
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        String method = request.getMethodValue();
        String path = request.getURI().getPath();
        // 跳过token校验，放在这里去做是为了能够动态刷新
        if (this.skipValid(path)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 如果token为空 或者token不合法 则进行拦截
        String restfulPath = method + ":" + path; // RESTFul接口权限设计 @link https://www.cnblogs.com/haoxianrui/p/14961707.html
        String token = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION_KEY);
        if (StrUtil.isBlank(token) || !StrUtil.startWithIgnoreCase(token, SecurityConstants.JWT_PREFIX)) {
            return Mono.just(new AuthorizationDecision(false));
        }

        /**
         * 从redis中获取资源权限. admin初始化时，已用监听器将所有权限加载到redis中
         * */
        RMap<Object, Object> rMap = redissonClient.getMap(GlobalConstants.URL_PERM_ROLES_KEY);
        Map<Object, Object> urlPermRolesRules = rMap.readAllMap();
        List<String> authorizedRoles = new ArrayList<>(); // 拥有访问权限的角色
        boolean requireCheck = false; // 是否需要鉴权，默认未设置拦截规则不需鉴权

        for (Map.Entry<Object, Object> permRoles : urlPermRolesRules.entrySet()) {
            String perm = (String) permRoles.getKey();
            if (pathMatcher.match(perm, restfulPath)) {
                List<String> roles = Convert.toList(String.class, permRoles.getValue());
                authorizedRoles.addAll(Convert.toList(String.class, roles));
                if (requireCheck == false) {
                    requireCheck = true;
                }
            }
        }

        // 如果资源不需要权限 则直接返回授权成功
        if (!requireCheck) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 判断JWT中携带的用户角色是否有权限访问
        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {
                    String roleCode = authority.substring(SecurityConstants.AUTHORITY_PREFIX.length()); // 用户的角色
                    boolean hasAuthorized = CollectionUtil.isNotEmpty(authorizedRoles) && authorizedRoles.contains(roleCode);
                    return hasAuthorized;
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;
    }

    /**
     * 跳过校验
     *
     * @param path
     * @return
     */
    private boolean skipValid(String path) {
        for (String skipPath : ignoreUrls) {
            if (UrlPatternUtils.match(skipPath, path)) {
                return true;
            }
        }
        return false;
    }
}
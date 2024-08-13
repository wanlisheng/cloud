package auth.security.config;

import auth.common.enums.ClientEnums;
import auth.security.details.MoreAuthenticatedUserDetailsService;
import base.result.R;
import base.result.ResultCode;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 安全拦截配置
 * */
@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService memberUserDetailsService;
    private final UserDetailsService sysUserDetailsService;
    private final String realName = ".";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/oauth/**","/test/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                //关闭csrf跨域检查
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint());
    }

    /**
     * 认证管理对象
     *
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 添加自定义认证器
     *
     * @param auth
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.daoAuthenticationProvider());
    }

    /**
     * 设置默认的用户名密码认证授权提供者
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        Map<String, UserDetailsService> userDetailsServiceMap = new HashMap<>();
        userDetailsServiceMap.put(ClientEnums.ADMIN_CLIENT.getName(), sysUserDetailsService);
        userDetailsServiceMap.put(ClientEnums.MEMBER_CLIENT.getName(), memberUserDetailsService);
        MoreAuthenticatedUserDetailsService moreAuthenticatedUserDetailsService = new MoreAuthenticatedUserDetailsService(userDetailsServiceMap);

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(moreAuthenticatedUserDetailsService);
        provider.setPasswordEncoder(this.passwordEncoder());
        provider.setHideUserNotFoundExceptions(false); // 是否隐藏用户不存在异常，默认:true-隐藏；false-抛出异常；
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 自定义认证异常响应数据
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, e) -> {
            if (e instanceof InsufficientAuthenticationException){
                response.addHeader("WWW-Authenticate", "Basic realm= "+realName);
                response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
            }else{
                response.setStatus(cn.hutool.http.HttpStatus.HTTP_OK);
                response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Cache-Control", "no-cache");
                R result = R.failed(ResultCode.CLIENT_AUTHENTICATION_FAILED);
                response.getWriter().print(JSONUtil.toJsonStr(result));
                response.getWriter().flush();
            }
        };
    }

}

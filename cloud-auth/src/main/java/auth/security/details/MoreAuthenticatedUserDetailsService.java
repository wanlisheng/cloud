package auth.security.details;


import auth.common.utils.CommonUtils;
import base.result.ResultCode;
import com.alibaba.csp.sentinel.util.AssertUtil;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("moreUserDetailsService")
@NoArgsConstructor
public class MoreAuthenticatedUserDetailsService implements UserDetailsService {


    private Map<String, UserDetailsService> userDetailsServiceMap;

    public MoreAuthenticatedUserDetailsService(Map<String, UserDetailsService> userDetailsServiceMap) {
        this.userDetailsServiceMap = userDetailsServiceMap;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String clientId = CommonUtils.getOAuth2ClientId();
        AssertUtil.notEmpty(clientId, String.valueOf(ResultCode.PARAM_IS_NOT_EMPTY));
        UserDetailsService userDetailsService = userDetailsServiceMap.get(clientId);
        return userDetailsService.loadUserByUsername(userName);
    }
}

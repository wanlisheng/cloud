package admin.service.impl;

import admin.dto.UserAuthDTO;
import admin.entity.SysUser;
import admin.mapper.SysUserMapper;
import admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public UserAuthDTO getByUsername(String username) {
        UserAuthDTO userAuthInfo = this.baseMapper.getByUsername(username);
        return userAuthInfo;
    }

}

package admin.service;


import admin.dto.MemberUserAuthDTO;
import admin.entity.MemberUser;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IMemberUserService extends IService<MemberUser> {


    /**
     * 根据用户名获取认证用户信息，携带角色和密码
     *
     * @param username
     * @return
     */
    MemberUserAuthDTO getByUsername(String username);

}

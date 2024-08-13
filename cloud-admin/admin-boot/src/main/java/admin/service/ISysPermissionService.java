package admin.service;

import admin.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 刷新Redis缓存中角色菜单的权限规则，角色和菜单信息变更调用
     */
    boolean refreshPermRolesRules();

    List<SysPermission> listPermRoles();
}

package admin.mapper;


import admin.dto.UserAuthDTO;
import admin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    UserAuthDTO getByUsername(@Param("userName") String userName);
}

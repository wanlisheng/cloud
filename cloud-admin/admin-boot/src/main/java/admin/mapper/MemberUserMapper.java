package admin.mapper;


import admin.dto.MemberUserAuthDTO;
import admin.entity.MemberUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface MemberUserMapper extends BaseMapper<MemberUser> {

    MemberUserAuthDTO getByUsername(@Param("userName") String userName);
}

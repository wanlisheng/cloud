package admin.service.impl;


import admin.dto.MemberUserAuthDTO;
import admin.entity.MemberUser;
import admin.mapper.MemberUserMapper;
import admin.service.IMemberUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberUserServiceImpl extends ServiceImpl<MemberUserMapper, MemberUser> implements IMemberUserService {
    @Override
    public MemberUserAuthDTO getByUsername(String username) {
        MemberUserAuthDTO memberUserAuthDTO = this.baseMapper.getByUsername(username);
        return memberUserAuthDTO;
    }

}

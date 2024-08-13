package admin.service.impl;

import admin.entity.SysOauthClient;
import admin.mapper.SysOauthClientMapper;
import admin.service.ISysOauthClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class SysOauthClientServiceImpl extends ServiceImpl<SysOauthClientMapper, SysOauthClient> implements ISysOauthClientService {

}

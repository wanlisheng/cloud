package seater.account.service;

import seater.account.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


@Service
public interface AccountService extends IService<Account> {

    void decrease(Long userId, Integer money);
}
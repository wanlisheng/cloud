package seater.account.service.impl;

import seater.account.dao.AccountMapper;
import seater.account.entity.Account;
import seater.account.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Override
    public void decrease(Long userId, Integer money) {
        Account account = lambdaQuery().eq(Account::getUserId, userId).one();

        lambdaUpdate().set(Account::getUsed, account.getUsed() + money)
                .set(Account::getResidue, account.getResidue() - money)
                .eq(Account::getUserId, userId)
                .update();
    }
}

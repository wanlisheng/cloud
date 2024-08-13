package seater.account.controller;


import base.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import seater.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @RequestMapping("/decrease")
    public R decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        accountService.decrease(userId, money);
        return R.ok("余额扣减成功");
    }
}

package admin.controller;


import base.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/passwd")
@RequiredArgsConstructor
public class PasswdController {
    private final PasswordEncoder passwordEncoder;
    @RequestMapping("/genPasswd")
    public R<String> genPasswd(/*@PathVariable("passwd") String passwd*/){
        return R.ok("genPasswd");
    }
}

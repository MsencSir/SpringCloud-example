package net.gichain.config;

import net.gichain.service.LoginService;
import org.springframework.stereotype.Component;

/**
 * @Author MsencSir
 * @Date 2020/5/21 17:11
 * 服务降级实现
 */
@Component
public class LoginServiceFallBack implements LoginService {

    @Override
    public String login(String name) { return "登录服务系统繁忙,请稍后重试"; }

    @Override
    public String signOut(String name) { return "退出服务系统繁忙,请稍后重试"; }
}

package net.gichain.test.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author MsencSir
 * @Date 2020/5/12 15:40
 */
@Slf4j
@RefreshScope//实时刷新最新配置 不加此注解配置中心参数更新,程序不能即时获取到
@RestController
public class LoginController {

    @Value("${conf.nacosName}")
    private String nacosName;

    @Resource
    LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam("name") String name){
        log.info("客户端收到登录请求："+name);
        log.info("nacosName："+nacosName);
        return loginService.login(name);
    }

    @GetMapping("/signOut")
    public String signOut(@RequestParam("name") String name){
        log.info("客户端收到退出登录请求："+name);
        return loginService.signOut(name);
    }
}

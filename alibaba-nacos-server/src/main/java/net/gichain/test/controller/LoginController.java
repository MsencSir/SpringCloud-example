package net.gichain.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MsencSir
 * @Date 2020/5/12 15:40
 */
@Slf4j
@RefreshScope//实时刷新最新配置 不加此注解配置中心参数更新,程序不能即时获取到
@RestController
public class LoginController {

    @Value("${conf.debug:false}")
    private Boolean debug;

    @GetMapping("/login")
    public String login(@RequestParam("name") String name){
        log.info("服务端收到登录请求："+name);
        log.info(String.format("是否允许：%s 登录：%s",name,debug));
        try {
            Thread.sleep(7000);//模拟业务运行 用于验证服务降级
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name+"登录成功结果:"+debug;
    }

    @GetMapping("/signOut")
    public String signOut(@RequestParam("name") String name){
        log.info("服务端收到退出登录请求："+name);
        log.info(String.format("是否允许：%s 登录：%s",name,debug));
        return name+"退出登录结果:"+debug;
    }
}

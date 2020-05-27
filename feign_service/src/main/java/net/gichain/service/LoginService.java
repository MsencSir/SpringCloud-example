package net.gichain.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.gichain.config.LoginServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author MsencSir
 * @Date 2020/5/8 21:04
 * feign客户端接口
 */
@FeignClient(name = "${feign.login.service}",fallback = LoginServiceFallBack.class)
public interface LoginService {

    //@HystrixCommand(fallbackMethod="login")
    @GetMapping(value = "/login")
    String login(@RequestParam(name = "name") String name);

    @GetMapping(value = "/signOut")
    String signOut(@RequestParam(name = "name") String name);
}

package net.gichain.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "net.gichain.service")
@ComponentScan(basePackages = {"net.gichain.config","net.gichain.test"})
@SpringBootApplication
public class AlibabaNacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosClientApplication.class, args);
    }

}

package com.qf.j1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//开启服务查找（发现）功能
@EnableDiscoveryClient
//开启feign负载均衡
@EnableFeignClients
//开启熔断服务
//@EnableHystrix
@SpringBootApplication
public class J1902SpringcloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(J1902SpringcloudFeignApplication.class, args);
	}

}

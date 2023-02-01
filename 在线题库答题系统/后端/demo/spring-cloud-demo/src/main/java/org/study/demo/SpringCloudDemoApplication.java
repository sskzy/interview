package org.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Since: 2022/11/13 4:37 pm
 * 套中套异常:
 *      Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6eeb83fb]
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}

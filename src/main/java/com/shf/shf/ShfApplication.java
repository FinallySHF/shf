package com.shf.shf;

import com.shf.shf.config.verify.VerifyServlet;
import com.shf.shf.core.datasource.EnableMultipleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

//@EnableRedisHttpSession
@SpringBootApplication
@EnableMultipleDataSource
public class ShfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShfApplication.class, args);
    }

    /**
     * 注入验证码servlet
     * 生成验证码功能
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }

}

package com.shf.shf;

import com.shf.shf.core.datasource.EnableMultipleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableMultipleDataSource
public class ShfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShfApplication.class, args);
    }

}

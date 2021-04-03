package io.github.lexcao.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringDataJpaJoinTableApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringDataJpaJoinTableApplication.class, args);
        TimeUnit.SECONDS.sleep(100);
    }

}

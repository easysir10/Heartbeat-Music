package com.demo.music_with_heart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.demo.music_with_heart.dao")
@SpringBootApplication
public class MusicWithHeartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicWithHeartApplication.class, args);
    }

}

package com.takeneat.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author paoesco
 */
@SpringBootApplication
public class Boot {

    private Boot() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

}

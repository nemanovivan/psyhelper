package com.itgirls.psyhelper1;

import com.itgirls.psyhelper1.service.impl.QuestionThemeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Psyhelper1Application {
    private static final Logger logger = LoggerFactory.getLogger(Psyhelper1Application.class);

    public static void main(String[] args) {
        logger.info("Starting application...");
        SpringApplication.run(Psyhelper1Application.class, args);
    }
    }

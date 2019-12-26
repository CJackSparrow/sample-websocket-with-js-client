package com.topica.alert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class AlertApp {

  public static void main(String[] args) {
    log.info("Start alert application");
    SpringApplication.run(AlertApp.class, args);
  }

}

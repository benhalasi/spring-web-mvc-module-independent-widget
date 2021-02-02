package com.example.demo;

import com.example.demo.config.ModuleConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

  @Autowired
  private void method (ModuleConfig moduleConfig) {
    log.info(moduleConfig.getPath());
  }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
  }
}

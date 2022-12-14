package dev.benedek.poc.mvc.piw.exampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import dev.benedek.poc.mvc.piw.core.PageIndependentWidgetRoot;

@SpringBootApplication
@ComponentScan(basePackageClasses = { ExampleAppApplication.class, PageIndependentWidgetRoot.class })
public class ExampleAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExampleAppApplication.class, args);
  }

}

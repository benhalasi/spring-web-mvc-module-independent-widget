package dev.benedek.poc.mvc.piw.exampleapp.session;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Session {

  private final String id = UUID.randomUUID().toString() + "." + System.currentTimeMillis();

  public String getId() {
    return id;
  }

}

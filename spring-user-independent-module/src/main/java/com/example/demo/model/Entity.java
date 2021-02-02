package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entity {
  
  private final static Logger log = LoggerFactory.getLogger(Entity.class);

  private String data = "initalized with ";

  public Entity(String data) {
    log.info("contruct w/ data: {}.", data);
    this.data += data.substring(0, 5);
  }

  public Entity() {
    log.info("contruct.");
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}

package com.example.demo.service;

import com.example.demo.model.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageBlakeService {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ModuleService moduleService;

  public PageBlakeService (){
    log.info("construct.");
  }

  public Entity get(String id) {
    log.info("get {}", id);
    return moduleService.get(id);
  }
}

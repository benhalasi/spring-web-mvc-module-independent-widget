package com.example.demo.service;

import com.example.demo.model.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageAsherService {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private ModuleService moduleService;

  @Autowired
  private void init (ModuleService moduleService) {
    this.moduleService = moduleService;
  }

  public PageAsherService (){
    log.info("construct.");
  }

  public Entity get(String id) {
    log.info("get {}", id);
    moduleService.register(id, entity -> "redirect:/asher/");
    return moduleService.get(id);
  }
}

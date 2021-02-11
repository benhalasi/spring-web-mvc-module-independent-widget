package dev.benedek.poc.mvc.piw.exampleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.benedek.poc.mvc.piw.pageindependentwidget.model.Entity;
import dev.benedek.poc.mvc.piw.pageindependentwidget.service.ModuleService;

@Service
public class PageBlakeService {

  @Autowired
  private ModuleService moduleService;

  public Entity get(String id) {
    return moduleService.get(id);
  }
}

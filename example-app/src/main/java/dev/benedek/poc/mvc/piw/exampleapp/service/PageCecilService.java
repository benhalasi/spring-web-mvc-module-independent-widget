package dev.benedek.poc.mvc.piw.exampleapp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.benedek.poc.mvc.piw.pageindependentwidget.model.Entity;
import dev.benedek.poc.mvc.piw.pageindependentwidget.service.ModuleService;

@Service
public class PageCecilService {

  private static final Logger log = LoggerFactory.getLogger(PageCecilService.class);
  
  @Autowired
  private ModuleService moduleService;
  
  public Entity get(String id) {
    return moduleService.get(id, this::callback);
  }
  
  private Optional<String> callback (Entity entity) {
    log.info("Modification callback of: {}, no.: {}, data: {}. Using custom url.", entity, entity.getTicketNumber(), entity.getData());
    return Optional.of("redirect:/cecil?ticket="+entity.getTicketNumber()+"/");
  }
}

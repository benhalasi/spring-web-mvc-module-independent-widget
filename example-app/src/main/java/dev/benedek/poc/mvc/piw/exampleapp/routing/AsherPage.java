package dev.benedek.poc.mvc.piw.exampleapp.routing;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.benedek.poc.mvc.piw.core.model.Entity;
import dev.benedek.poc.mvc.piw.core.service.ModuleService;
import dev.benedek.poc.mvc.piw.exampleapp.session.Session;
import dev.benedek.poc.mvc.piw.exampleapp.templating.PageTemplateService;

@Controller
@RequestMapping("/asher/")
public class AsherPage {

  private static final Logger log = LoggerFactory.getLogger(AsherPage.class);

  @Autowired
  private ModuleService moduleService;

  @Autowired
  private Session session;

  @Autowired
  private PageTemplateService template;

  @GetMapping
  @ResponseBody
  public String get() {
    String id = session.getId() + ".asher"; // unique id for this session and 'asher' keywords
    Entity entity = moduleService.get(id, this::callback);

    return template.getHTML(id, entity, "Asher Page");
  }

  private Optional<String> callback(Entity entity) {
    log.info("Modification callback of: {}, no.: {}, data: {}.", entity, entity.getTicketNumber(), entity.getData());
    return Optional.empty();
  }
}

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
@RequestMapping("/cecil")
public class CecilPage {

  private static final Logger log = LoggerFactory.getLogger(CecilPage.class);

  @Autowired
  private ModuleService moduleService;

  @Autowired
  private Session session;

  @Autowired
  private PageTemplateService template;

  @GetMapping
  @ResponseBody
  public String get() {
    String id = session.getId() + ".cecil"; // unique id for this session and 'cecil' keywords
    Entity entity = moduleService.get(id, this::callback);

    return template.getHTML(id, entity, "Cecil Page");
  }

  private Optional<String> callback(Entity entity) {
    log.info("Modification callback of: {}, no.: {}, data: {}. Using custom url.",
        entity, entity.getTicketNumber(), entity.getData());

    return Optional.of("redirect:/cecil/?ticket=" + entity.getTicketNumber() + "/");
  }
}

package dev.benedek.poc.mvc.piw.exampleapp.routing;

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
@RequestMapping("/shared_b/")
public class SharedBPage {

  @Autowired
  private ModuleService moduleService;

  @Autowired
  private Session session;

  @Autowired
  private PageTemplateService template;

  @GetMapping
  @ResponseBody
  public String get() {
    String id = session.getId() + ".shared"; // unique id for this session and 'shared' keywords
    Entity entity = moduleService.get(id);

    return template.getHTML(id, entity, "Shared 'B' Page");
  }
}

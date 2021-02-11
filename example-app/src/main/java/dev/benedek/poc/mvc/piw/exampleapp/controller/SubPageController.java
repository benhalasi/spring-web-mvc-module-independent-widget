package dev.benedek.poc.mvc.piw.exampleapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.benedek.poc.mvc.piw.exampleapp.service.PageAsherService;
import dev.benedek.poc.mvc.piw.exampleapp.service.PageBlakeService;
import dev.benedek.poc.mvc.piw.exampleapp.service.PageCecilService;
import dev.benedek.poc.mvc.piw.pageindependentwidget.controller.ModuleController;
import dev.benedek.poc.mvc.piw.pageindependentwidget.model.Entity;

@Controller
public class SubPageController {
  
  @Autowired
  private PageAsherService asherService;

  @Autowired
  private PageBlakeService blakeService;

  @Autowired
  private PageCecilService cecilService;

  /**
   * only using it to get editorHTML,
   * will be removed when template engine is configured.
   */
  @Autowired
  private ModuleController moduleController;

  @GetMapping("/asher")
  @ResponseBody
  public String getAsher(HttpSession session) {
    String id = session.getId() + "_p1";
    Entity entity = asherService.get(id);

    return getHTML(id, entity, "Page 1 - asher");
  }

  @GetMapping("/blake")
  @ResponseBody
  public String getBlake(HttpSession session) {
    String id = session.getId() + "_p2";
    Entity entity = blakeService.get(id);

    return getHTML(id, entity, "Page 2 - blake");
  }

  @GetMapping("/cecil")
  @ResponseBody
  public String getCecil(HttpSession session) {
    String id = session.getId() + "_p3";
    Entity entity = cecilService.get(id);

    return getHTML(id, entity, "Page 3 - cecil");
  }

  private String getHTML(String id, Entity entity, String head) {
    return new StringBuffer()
      .append("<h1>").append(head).append("</h1>")
      .append("<p>id: ").append(id).append("</p>")
      .append("<p>ticket number: " + entity.getTicketNumber() + "</p>")
      .append("<p>current data: " + entity.getData() + "</p>")
      // TODO: this snippet can be easily delegated to a template engine. do that.
      .append(moduleController.editorHTML(id))
      .append("<p/><a href='/'>root</a></p>")
      .toString();
  }
}

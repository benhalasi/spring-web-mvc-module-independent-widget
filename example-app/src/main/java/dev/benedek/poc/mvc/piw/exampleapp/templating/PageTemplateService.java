package dev.benedek.poc.mvc.piw.exampleapp.templating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.benedek.poc.mvc.piw.core.controller.ModuleController;
import dev.benedek.poc.mvc.piw.core.model.Entity;

/**
 * We have Thymeleaf at home.
 *
 * TemplatePageService mocks example pages' contents. Naturaly this would be
 * delegated to Thymeleaf or other template engines.
 *
 * This class calls {@link ModuleController} to fetch the expected widget's
 * html, which exact implementation is also a template engine specific
 * question.
 *
 */
@Service
public class PageTemplateService {

  @Autowired
  private ModuleController moduleController;

  public String getHTML(String id, Entity entity, String head) {
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

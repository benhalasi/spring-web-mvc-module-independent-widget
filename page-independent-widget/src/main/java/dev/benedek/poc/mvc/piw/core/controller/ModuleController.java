package dev.benedek.poc.mvc.piw.core.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.benedek.poc.mvc.piw.core.model.Entity;
import dev.benedek.poc.mvc.piw.core.service.ModuleService;

@Controller
@RequestMapping("${module.path:/}")
public class ModuleController {

  @Value("${module.path:/}")
  private String URI;

  @Autowired
  private ModuleService service;

  // Migrate to PostMapping and forms
  @GetMapping("{key}/{data}")
  public String set(HttpServletRequest request, @PathVariable String key, @PathVariable String data) {
    // read more
    // @https://stackoverflow.com/questions/804581/spring-mvc-controller-redirect-to-previous-page
    // keep in mind that Referer could be null
    String referer = request.getHeader("Referer");
    String redirectToRefererURI = "redirect:" + referer;

    // result of specified callback method
    Optional<String> defaultURI = service.set(key, data);

    // could be a one-liner tho
    return defaultURI.orElse(redirectToRefererURI);
  }

  @GetMapping("{id}")
  @ResponseBody
  public String editorHTML(@PathVariable String id) {
    Entity entity = service.get(id);

    return new StringBuffer()
        .append("<input id='input' value='").append(entity.getData()).append("'><br/>")
        .append("<script>")
        // idk why i did not use forms ....
        // TODO: forms
        .append("let gen = () => '").append(URI).append(id).append("/' + document.getElementById('input').value")
        .append("</script>")
        .append("<button onclick='window.location=gen()'").append(">save</button>")
        .toString();
  }
}

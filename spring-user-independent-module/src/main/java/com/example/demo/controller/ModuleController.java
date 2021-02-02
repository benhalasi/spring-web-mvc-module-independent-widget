package com.example.demo.controller;

import com.example.demo.model.Entity;
import com.example.demo.service.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${module.path}")
public class ModuleController {

  @Value("${module.path}")
  private String URI;

  @Autowired
  private ModuleService service;

  @GetMapping("{id}/{data}")
  public String update(@PathVariable String id, @PathVariable String data) {
    return service.set(id, data);
  }

  @GetMapping("{id}")
  public String editorHTML (@PathVariable String id) {
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

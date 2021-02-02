package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Entity;
import com.example.demo.service.PageBlakeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blake/")
public class PageBlakeController {

  @Autowired
  private ModuleController moduleController;
  
  @Autowired
  private PageBlakeService service;

  @GetMapping("")
  @ResponseBody
  public String get (HttpSession session) {
    String id = session.getId() + "_page2";
    Entity entity = service.get(id);

    return new StringBuffer()
      .append("<h1>Page 2 - blake</h1><p>id: ").append(id).append("</p>")
      .append("<p>current data: " + entity.getData() + "</p>")
      // this snippet can be easily delegated to a template engine. TODO: do exactly that.
      .append(moduleController.editorHTML(id))
      .append("<p/><a href='/'>root</a></p>")
      .toString();
  }
}

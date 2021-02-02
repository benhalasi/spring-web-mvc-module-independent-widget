package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping({"", "/"})
public class PageRootController {
  
  @GetMapping("")
  @ResponseBody
  public String get() {
    return "<a href='/asher/'>Page 1</a><br/><a href='/blake/'>Page 2</a>";
  }
}

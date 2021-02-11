package dev.benedek.poc.mvc.piw.exampleapp.controller;

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
    return "<a href='/asher/'>Page with callback method</a><br/><a href='/blake/'>Page without callback method</a><br/><a href='/cecil/'>Page with custom URI</a>";
  }
}

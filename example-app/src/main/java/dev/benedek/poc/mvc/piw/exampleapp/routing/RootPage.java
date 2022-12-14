package dev.benedek.poc.mvc.piw.exampleapp.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.benedek.poc.mvc.piw.exampleapp.session.Session;

@Controller
@RequestMapping({ "", "/" })
public class RootPage {

  @Autowired
  private Session session;

  @GetMapping("")
  @ResponseBody
  public String get() {
    return new StringBuffer()
        .append("<p>Hi " + session.getId() + " !!</p>")
        .append("<a href='/asher/'>Page with callback method</a>").append("<br/>")
        .append("<a href='/blake/'>Page without callback method</a>").append("<br/>")
        .append("<a href='/cecil/'>Page with custom URI</a>").append("<br/>")
        .append("<a href='/shared_a/'>Pages that are sharing a widget with eachother.</a>").append("<br/>")
        .append("<a href='/shared_b/'>Pages that are sharing a widget with eachother.</a>").append("<br/>")
        .toString();
  }
}

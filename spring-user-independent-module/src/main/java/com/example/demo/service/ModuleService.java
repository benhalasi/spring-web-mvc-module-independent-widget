package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.example.demo.model.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class ModuleService {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private final Map<String, Entity> dataStore = new HashMap<>();
  private final Map<String, Function<Entity, String>> callbacks = new HashMap<>();

  public ModuleService () {
    log.info("construct.");
  }

  public Entity get(String id) {
    log.info("get {}", id);

    if (!dataStore.containsKey(id)){
      log.info("get {} - absent, creating new", id);
      dataStore.put(id, new Entity(id));
    }

    log.info("get {} - {}", id, dataStore.get(id).getData());
    return dataStore.get(id);
  }

  public String set(String id, String data) {
    log.info("set {}, {}", id, data);
    var entity = dataStore.get(id);
    if(entity != null){
      entity.setData(data);
    }

    return callbacks.getOrDefault(id, this::defaultCallback).apply(entity);
  }

  public void register(String id, Function<Entity, String> callback) {
    callbacks.put(id, callback);
  }

  public String defaultCallback (Entity entity) {
    return "redirect:/";
  }
}

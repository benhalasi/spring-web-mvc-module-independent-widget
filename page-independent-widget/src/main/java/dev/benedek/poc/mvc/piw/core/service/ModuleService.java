package dev.benedek.poc.mvc.piw.core.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import dev.benedek.poc.mvc.piw.core.model.Entity;

@Service
@ApplicationScope
public class ModuleService {
  private final Map<String, Entity> dataStore = new HashMap<>();
  private final Map<String, Function<Entity, Optional<String>>> callbacks = new ConcurrentHashMap<>();

  public Entity get(String key) {
    return dataStore.computeIfAbsent(key, Entity::new);
  }

  public Entity get(String key, Function<Entity, Optional<String>> callback) {
    Entity entity = get(key);
    addCallback(key, callback);
    return entity;
  }

  /**
   * @param key
   * @param data
   * @return Result of specified callback method.
   */
  public Optional<String> set(String key, String data) {
    return Optional.ofNullable(dataStore.get(key))
        .flatMap(entity -> {
          entity.setData(data);
          return callbacks.getOrDefault(key, this::defaultCallback).apply(entity);
        });
  }

  private void addCallback(String id, Function<Entity, Optional<String>> callback) {
    callbacks.put(id, callback);
  }

  private Optional<String> defaultCallback(Entity entity) {
    return Optional.empty();
  }
}

package dev.benedek.poc.mvc.piw.core.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Entity {
  private static AtomicLong counter = new AtomicLong();

  private final long ticketNumber = counter.getAndIncrement();
  private String data = "Entity nr. " + ticketNumber + ", created at " + LocalDateTime.now();

  public Entity(String data) {
    this.data += " - " + data.substring(0, Math.min(5, data.length()));
  }

  public long getTicketNumber() {
    return ticketNumber;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}

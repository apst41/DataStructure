package org.example.structural.factory;

import org.example.enums.Source;

public class NotificationFactory {
  public Notification createNotification(Source source) {
    switch (source) {
      case SMS:
        return new SMSNotification();
      case EMAIL:
        return new EmailNotification();
      default:
        throw new IllegalArgumentException("Unknown channel " + source);
    }
  }
}

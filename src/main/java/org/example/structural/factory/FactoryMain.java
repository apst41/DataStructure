package org.example.structural.factory;

import org.example.enums.Source;

public class FactoryMain {
  public static void main(String[] args) {
    NotificationFactory notificationFactory = new NotificationFactory();
    notificationFactory.createNotification(Source.SMS).sendNotification();
    notificationFactory.createNotification(Source.EMAIL).sendNotification();
  }
}

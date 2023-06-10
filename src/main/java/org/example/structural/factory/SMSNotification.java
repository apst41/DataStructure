package org.example.structural.factory;

public class SMSNotification implements Notification {
  @Override
  public void sendNotification() {
    System.out.println("send SMS Notification");
  }
}

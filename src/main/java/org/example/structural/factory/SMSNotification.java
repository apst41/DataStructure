package org.example.structural;

public class SMSNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("send SMS Notification");
    }
}

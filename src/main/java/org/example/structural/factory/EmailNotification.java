package org.example.structural;

public class EmailNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Send Email Notification");
    }
}

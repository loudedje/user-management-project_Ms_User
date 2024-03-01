package com.notification.userNotification.service;

import com.notification.userNotification.enums.Event;
import com.notification.userNotification.model.Notification;
import com.notification.userNotification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
    public void createNotification(String email, Event event) {
        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setEvent(event);
        notification.setDate(LocalDateTime.now());
        notificationRepository.save(notification);
    }

}

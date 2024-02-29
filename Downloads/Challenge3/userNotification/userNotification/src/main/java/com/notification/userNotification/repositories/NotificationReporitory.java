package com.notification.userNotification.repositories;

import com.notification.userNotification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public class NotificationReporitory {

    public interface NotificationRepository extends JpaRepository<Notification, Long> {
    }

}

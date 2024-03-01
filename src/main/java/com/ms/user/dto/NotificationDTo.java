package com.notification.userNotification.dto;

import com.notification.userNotification.enums.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDTo {
    private String email;
    private Event event;

    private LocalDateTime date;
}

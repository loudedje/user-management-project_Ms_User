package com.notification.userNotification.model;

import com.notification.userNotification.enums.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String email;
        private Event event;
        private LocalDateTime date;
    }


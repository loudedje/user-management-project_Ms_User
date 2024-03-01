package com.notification.userNotification.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.userNotification.constant.RabbitmqCons;
import com.notification.userNotification.dto.NotificationDTo;
import com.notification.userNotification.model.Notification;
import com.notification.userNotification.repositories.NotificationRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumers {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationRepository notificationRepository;

    @RabbitListener(queues = RabbitmqCons.FILA_NOTIFICATION)
    private void consumidor(Message message){
        try {
            String jsonMessage = new String(message.getBody());
            NotificationDTo notificationDTO = objectMapper.readValue(jsonMessage, NotificationDTo.class);

            // Mapeando os campos da NotificationDTO para a entidade Notification
            Notification notification = new Notification();
            notification.setEmail(notificationDTO.getEmail());
            notification.setEvent(notificationDTO.getEvent());
            notification.setDate(notificationDTO.getDate());

            // Salvando a notificação no banco de dados
            notificationRepository.save(notification);

        } catch (Exception e) {
            // Lidar com erros de desserialização ou de salvamento no banco de dados
            e.printStackTrace();
        }
    }
}

package com.riderworkforcehub.notificationservice.messaging;

import com.riderworkforcehub.notificationservice.model.Notification;
import com.riderworkforcehub.notificationservice.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class IncentiveRewardedEventConsumer {

    private final Logger logger = LoggerFactory.getLogger(IncentiveRewardedEventConsumer.class);
    private final NotificationService notificationService;

    public IncentiveRewardedEventConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "incentive.rewarded.topic", groupId = "notification-consumers")
    public void consume(ConsumerRecord<String, String> record) {
        logger.info("Consumed message: {}", record.value());

        // parse message or use JSON library if needed
        Notification notification = new Notification();
        notification.setRiderId(123L); // extract from event
        notification.setMessage("You've been rewarded!");

        notificationService.save(notification);
    }
}

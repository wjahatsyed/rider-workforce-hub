package com.riderworkforcehub.notificationservice.service.impl;

import com.riderworkforcehub.notificationservice.model.Notification;
import com.riderworkforcehub.notificationservice.repository.NotificationRepository;
import com.riderworkforcehub.notificationservice.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByRiderId(Long riderId) {
        return repository.findByRiderId(riderId);
    }
}

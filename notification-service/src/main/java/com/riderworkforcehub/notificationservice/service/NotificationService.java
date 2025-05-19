package com.riderworkforcehub.notificationservice.service;

import com.riderworkforcehub.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);
    List<Notification> getNotificationsByRiderId(Long riderId);
}

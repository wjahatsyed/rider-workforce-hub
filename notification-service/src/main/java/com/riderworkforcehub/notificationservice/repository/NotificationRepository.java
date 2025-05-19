package com.riderworkforcehub.notificationservice.repository;

import com.riderworkforcehub.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRiderId(Long riderId);
}

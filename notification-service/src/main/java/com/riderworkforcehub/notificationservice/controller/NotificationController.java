package com.riderworkforcehub.notificationservice.controller;

import com.riderworkforcehub.notificationservice.model.Notification;
import com.riderworkforcehub.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/rider/{riderId}")
    public ResponseEntity<List<Notification>> getByRider(@PathVariable Long riderId) {
        return ResponseEntity.ok(notificationService.getNotificationsByRiderId(riderId));
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification saved = notificationService.save(notification);
        return ResponseEntity.ok(saved);
    }

}

package com.riderworkforcehub.notificationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.riderworkforcehub.notificationservice.model.Notification;
import com.riderworkforcehub.notificationservice.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFetchNotificationsByRiderId() throws Exception {
        // Given
        Long riderId = 1L;

        Notification notification1 = Notification.builder()
                .id(101L)
                .riderId(riderId)
                .message("Your shift has been rewarded")
                .createdAt(LocalDateTime.now())
                .build();

        Notification notification2 = Notification.builder()
                .id(102L)
                .riderId(riderId)
                .message("Bonus incentive available")
                .createdAt(LocalDateTime.now())
                .build();

        List<Notification> notifications = List.of(notification1, notification2);

        when(notificationService.getNotificationsByRiderId(riderId)).thenReturn(notifications);

        // When & Then
        mockMvc.perform(get("/api/notifications/rider/{riderId}", riderId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(notifications.size()))
                .andExpect(jsonPath("$[0].id").value(notification1.getId()))
                .andExpect(jsonPath("$[0].message").value(notification1.getMessage()))
                .andExpect(jsonPath("$[1].id").value(notification2.getId()))
                .andExpect(jsonPath("$[1].message").value(notification2.getMessage()));
    }

    @Test
    void shouldCreateNotificationSuccessfully() throws Exception {
        // Given
        Notification input = Notification.builder()
                .riderId(1L)
                .message("New notification for rider")
                .createdAt(LocalDateTime.now())
                .build();

        Notification saved = Notification.builder()
                .id(999L)
                .riderId(input.getRiderId())
                .message(input.getMessage())
                .createdAt(input.getCreatedAt())
                .build();

        when(notificationService.save(Mockito.any(Notification.class))).thenReturn(saved);

        // When & Then
        mockMvc.perform(post("/api/notifications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(saved.getId()))
                .andExpect(jsonPath("$.riderId").value(saved.getRiderId()))
                .andExpect(jsonPath("$.message").value(saved.getMessage()));
    }

}

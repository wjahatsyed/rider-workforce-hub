package com.riderworkforcehub.incentiveservice.messaging

import com.riderworkforcehub.incentiveservice.event.ShiftCreatedEvent
import com.riderworkforcehub.incentiveservice.model.Incentive
import com.riderworkforcehub.incentiveservice.service.IncentiveService
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ShiftCreatedEventConsumer(
    private val incentiveService: IncentiveService
) {

    private val logger = LoggerFactory.getLogger(ShiftCreatedEventConsumer::class.java)

    @KafkaListener(topics = ["shift.created.topic"], groupId = "incentive-consumers")
    fun consume(event: ShiftCreatedEvent) {
        logger.info("Received ShiftCreatedEvent: $event")

        val incentive = Incentive(
            riderId = event.riderId,
            shiftId = event.shiftId,
            rewardPoints = 10 // Static reward for now
        )

        incentiveService.saveIncentive(incentive)
    }
}

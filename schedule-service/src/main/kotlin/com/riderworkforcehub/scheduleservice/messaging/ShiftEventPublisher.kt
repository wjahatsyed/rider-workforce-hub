package com.riderworkforcehub.scheduleservice.messaging

import com.riderworkforcehub.scheduleservice.event.ShiftCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ShiftEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    private val logger = LoggerFactory.getLogger(ShiftEventPublisher::class.java)

    fun publishShiftCreated(event: ShiftCreatedEvent) {
        logger.info("Publishing ShiftCreatedEvent: $event")
        kafkaTemplate.send("shift.created.topic", event)
    }
}

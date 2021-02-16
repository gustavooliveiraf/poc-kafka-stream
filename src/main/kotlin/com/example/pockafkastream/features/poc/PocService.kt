package com.example.pockafkastream.features.poc

import com.example.pockafkastream.features.poc.pubsub.PocTestSucceededEvent
import org.springframework.stereotype.Service
import java.util.*

@Service
class PocService(
    private val publisher: PocPublisherService,
) {
    fun publishEvent(name: String, id: UUID) {
        val event = PocTestSucceededEvent(name, id)
        publisher.testSucceededEvent(event)
    }
}

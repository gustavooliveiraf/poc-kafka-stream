package com.example.pockafkastream.features.poc

import com.example.pockafkastream.features.poc.pubsub.PocTestSucceededEvent
import com.example.pockafkastream.share.Topics
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PocPublisherService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun testSucceededEvent(event: PocTestSucceededEvent) {
        val string = event.name + " " + event.id
        kafkaTemplate.send(Topics.testSucceeded, string)
    }
}

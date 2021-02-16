package com.example.pockafkastream.features.poc.pubsub

import com.example.pockafkastream.infra.pubsub.BaseEvent
import java.util.*

data class PocTestSucceededEvent(val name: String, val id: UUID) : BaseEvent("poc_test_succeeded")

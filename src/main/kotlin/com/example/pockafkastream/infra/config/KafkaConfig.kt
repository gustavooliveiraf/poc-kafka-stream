package com.example.pockafkastream.infra.config

import com.example.pockafkastream.share.Topics
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableKafka
class KafkaConfig {
    @Bean
    fun topicTestSubmitted(): NewTopic {
        return NewTopic(Topics.testSucceeded, 1, 1.toShort())
    }

    @Bean
    fun topicTestSubmittedOutput(): NewTopic {
        return NewTopic(Topics.testSucceededOutput, 1, 1.toShort())
    }
}

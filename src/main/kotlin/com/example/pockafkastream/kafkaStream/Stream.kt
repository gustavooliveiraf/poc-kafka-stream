package com.example.pockafkastream.kafkaStream

import com.example.pockafkastream.share.Topics
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.Topology
import org.apache.kafka.streams.kstream.*
import java.util.*


class WordCountApplication {
    fun createTopology(inputTopic: String, outputTopic: String): Topology {
        val builder = StreamsBuilder()

        val source = builder.stream<String, String>(inputTopic)

        val counts = source
                .flatMapValues { value ->
                    value.toLowerCase(Locale.getDefault())
                            .split(" ".toRegex())
                            .dropLastWhile { it.isEmpty() }
                            .toList()
                }.groupBy { key, value -> value }
                .count()

        counts.toStream().to(outputTopic, Produced.with(Serdes.String(), Serdes.Long()))

        return builder.build()
    }

    fun streamConfiguration(): Properties {
        var streamsConfiguration = Properties()

        streamsConfiguration.put(
                StreamsConfig.APPLICATION_ID_CONFIG,
                "wordcount-live-test")

        val bootstrapServers = "localhost:9092"
        streamsConfiguration.put(
                StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers)

        streamsConfiguration.put(
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                Serdes.String().javaClass)

        streamsConfiguration.put(
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                Serdes.String().javaClass)

        return streamsConfiguration
    }

    fun start() {
        var inputTopic = Topics.testSucceeded
        var outputTopic = Topics.testSucceededOutput

        val topology = createTopology(inputTopic, outputTopic)
        val streamConfig = streamConfiguration()

        val streams = KafkaStreams(topology, streamConfig)
        streams.start()
//        streams.close()
    }
}

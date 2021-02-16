package com.example.pockafkastream

import com.example.pockafkastream.kafkaStream.WordCountApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocKafkaStreamApplication

fun main(args: Array<String>) {
	val wordCountApplication = WordCountApplication()
	wordCountApplication.start()

	runApplication<PocKafkaStreamApplication>(*args)
}

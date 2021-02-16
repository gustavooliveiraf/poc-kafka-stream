package com.example.pockafkastream.features.poc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PocController(
    private val pocService: PocService
) {
    @GetMapping
    fun get(
        @RequestParam name: String,
        @RequestParam id: UUID,
    ): String {
        pocService.publishEvent(name, id)
        return "OK"
    }
}

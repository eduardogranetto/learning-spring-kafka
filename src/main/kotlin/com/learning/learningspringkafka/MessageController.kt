package com.learning.learningspringkafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/V1/message")
class MessageController(
        private val objectMapper: ObjectMapper,
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @PostMapping
    fun create(@RequestBody message: Map<String, Any>) = ResponseEntity.ok(sendMessage(message))

    fun sendMessage(message: Map<String, Any>): Map<String, Any> {
        val key = message.getOrDefault("key", UUID.randomUUID().toString()).toString()
        kafkaTemplate.send("message_topic", key, objectMapper.writeValueAsString(message)).get()
        return message
    }

}
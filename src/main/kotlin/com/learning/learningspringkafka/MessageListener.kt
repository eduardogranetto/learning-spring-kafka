package com.learning.learningspringkafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class MessageListener {

    @KafkaListener(topics = ["message_topic"])
    fun receiveMessage(@Payload message: String){
        println("The message is: $message")
    }

}
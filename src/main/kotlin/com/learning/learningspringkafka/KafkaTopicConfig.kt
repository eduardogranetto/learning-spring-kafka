package com.learning.learningspringkafka

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaTopicConfig {

    @Bean
    fun messageTopic(): NewTopic = TopicBuilder.name("message_topic")
            .partitions(3)
            .replicas(1)
            .build()

}
package com.learning.learningspringkafka

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

class LearningSpringKafkaApplicationTests {

	@Test
	fun contextLoads() {
		Status.valueOf("CANCELLED")
	}

}

enum class Status{
	CONCLUDED
}

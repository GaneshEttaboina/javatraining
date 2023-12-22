package com.example.workoutApplication;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkoutApplicationTests {

	@Test
	void contextLoads() {
		assertSame(5,5);
	}

}

package com.lnt.springbootdemo;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lnt.springbootdemo.day3.CalcService;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	CalcService calcService;

	@Test
	public void firstTestCase(){
		assertTrue(true);
	}

	@Test
	public void testCalcServiceAddFunctionality(){
		// CalcService calcService = new CalcService();
		int result = calcService.add(3, 4);

		assertSame(7, result);
	}

}

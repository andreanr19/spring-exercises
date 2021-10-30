package com.andrea;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProbandoTestsApplicationTests {

	@Test
	@Tag("functional")
	void testOne() {

		System.out.println("Functional Test 1");
	}

	@Test
	@Tag("functional")
	void testTwo() {
		System.out.println("Functional Test 2");
	}
}

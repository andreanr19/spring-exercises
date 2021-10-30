package com.andrea;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NonFunctionalTest {

	@Test
	@Tag("performance")
	@Tag("Load")
	@Tag("non-functional")
	void testOne() {
		System.out.println("Non-Functional test 1 (Performance/Load)");
	}
}

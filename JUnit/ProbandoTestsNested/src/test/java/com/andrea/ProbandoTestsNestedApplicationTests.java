package com.andrea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Probando nested, display y repeated annotations")
class ProbandoTestsNestedApplicationTests {

	@BeforeEach
	void setUp1() {
		System.out.println("Setup 1");
	}
	
	@Test
	@DisplayName("test de la clase externa")
	void topTest() {
		System.out.println("Test 1");
	}
	
	
	@Nested 
	@DisplayName("clase interna 1")
	class InnerClass1{
		@BeforeEach
		void setUp2() {
			System.out.println("Setup 2");
		}
		
		@Test
		void innerTest1() {
			System.out.println("Test 2");
		}
		@RepeatedTest(5)
		void test() {
			System.out.println("Repeated test");
		}
		
		@Nested
		class InnerClass2{
			
			@Test
			@DisplayName("test de la clase más interna")
			void innerTest() {
				System.out.println("Test 3");
			}
		}
	}
}

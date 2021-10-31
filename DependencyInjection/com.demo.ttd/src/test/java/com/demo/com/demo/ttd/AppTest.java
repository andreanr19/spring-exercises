package com.demo.com.demo.ttd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;



public class AppTest 
{
	private void setUp() {
		Calculadora myCalculadora;
	}

	@Test
	public void metodoTest(String number1) {
		
		setUp();
		String entrada ="";
		if(entrada == "") {
			assertTrue(true);
		}else {
			String[] valores = entrada.split(",");
			if(valores.length>2) {
				fail();
			}else {
				try {
					Integer.parseInt(valores[0]);
					if(valores.length ==2)
						Integer.parseInt(valores[1]);
					assertTrue(true);
				}catch(NumberFormatException e) {
					fail();
				}
			}
		}
	}
}

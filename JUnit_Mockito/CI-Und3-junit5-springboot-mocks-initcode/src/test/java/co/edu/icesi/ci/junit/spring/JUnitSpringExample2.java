package co.edu.icesi.ci.junit.spring;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.ci.junit.spring.model.UserOrder;
import co.edu.icesi.ci.junit.spring.repositories.UserOrderRepository;
import co.edu.icesi.ci.junit.spring.service.UserOderService;
import lombok.extern.java.Log;

@Log
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes=SpringBootJunit5Application.class)
public class JUnitSpringExample2 {

	
	@Autowired
	public JUnitSpringExample2(UserOderService userOderService) {
		
		
		this.userOderService = userOderService;
	}


	@Mock
	private UserOrderRepository userOrderRepository;
	
	
	@InjectMocks
	private UserOderService userOderService;

	@BeforeAll
	public void setUp() {
		log.info("-----> SETUP <-----");
		
	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		// Check if the return description has a 'Description:' string.
		assertTrue(userOderService.getOrderDescription(0).contains("Description:"));
	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a 'Code:' string.
		assertTrue(userOderService.getOrderStringCode(0).contains("Code:"));
	}

	@Test
	public void testSampleServiceCreateNewOrder() {
		UserOrder newOrder = new UserOrder();
		newOrder.setSecurityCode("XYZ");
		newOrder.setDescription("Description");
		if (newOrder != null) {
			assertNotNull("Security isn't null", newOrder.getSecurityCode());
			assertNotNull("Description isn't not null", newOrder.getDescription());
		}

		assertNotNull(newOrder,"New Order is not null");

	}

	@Test
	public void testSampleServiceGetOrder() {

		UserOrder existingOrder = userOderService.getOrder(0);

		if (existingOrder != null) {
			assertNotNull("Security isn't null", existingOrder.getSecurityCode());
			assertNotNull("Description isn't null", existingOrder.getDescription());
		}

		assertNotNull(existingOrder,"Object is not null");
	}
	
	@Test
	public void testDeleteOrder() {
		UserOrder newOrder = new UserOrder();
		when(userOrderRepository.findById(1)).thenReturn(newOrder);
		
		newOrder.setSecurityCode("XYZ");
		newOrder.setDescription("Description");
		
		userOderService.deleteOrder(newOrder);
		verify(userOrderRepository).findById(1);
		verifyNoMoreInteractions(userOderService);
		}
	

	@AfterAll
	public static void afterTest() {
		log.info("-----> DESTROY <-----");
	}
}

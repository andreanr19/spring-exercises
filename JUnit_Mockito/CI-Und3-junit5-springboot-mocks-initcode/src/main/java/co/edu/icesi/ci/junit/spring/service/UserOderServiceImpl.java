package co.edu.icesi.ci.junit.spring.service;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import co.edu.icesi.ci.junit.spring.model.UserOrder;
import co.edu.icesi.ci.junit.spring.repositories.UserOrderRepository;

@Service
public class UserOderServiceImpl implements UserOderService {

	private UserOrderRepository userOrderRepository;
	public UserOderServiceImpl ()
	{
	}

	public String getOrderDescription(int id) {
		UserOrder existingOrder = new UserOrder();
		existingOrder.setDescription("Order for XYZ in units");
		return "Description: " + existingOrder.getDescription();
	}

	public String getOrderStringCode(int id) {
		UserOrder existingOrder = new UserOrder();
		existingOrder.setSecurityCode("XYZ");
		return "Account Code: " + existingOrder.getSecurityCode();
	}
	
	public UserOrder createOrder(UserOrder order) {
		UserOrder newOrder = new UserOrder();
		newOrder.setOrderId(new Random().nextInt());
		newOrder.setSecurityCode("XYZ");
		newOrder.setOrderStatus("INITIATED");
		newOrder.setOrderDate(new Date());
		return newOrder;
	}
	
	public UserOrder getOrder(int id) {
		UserOrder newOrder = new UserOrder();
		newOrder.setOrderId(new Random().nextInt());
		newOrder.setSecurityCode("XYZ");
		newOrder.setOrderStatus("COMPLETED");
		newOrder.setOrderDate(new Date());
		newOrder.setDescription("This is the new XYZ order");
		return newOrder;
	}
	
	public UserOrder updateOrder(UserOrder order) {
		UserOrder existingOrder = userOrderRepository.findById(order.getOrderId());
		existingOrder.setDescription(order.getDescription());
		existingOrder.setOrderStatus(order.getOrderStatus());
		existingOrder.setOrderDate(order.getOrderDate());
		userOrderRepository.save(existingOrder); // no necesario
		return order;
	}
	public void deleteOrder(UserOrder order) {
		
		UserOrder existingOrder = userOrderRepository.findById(order.getOrderId());
		userOrderRepository.delete(existingOrder);
	}
	
	@Override
	public void setUserOrderRepository(UserOrderRepository userOrderRepository) {
		this.userOrderRepository = userOrderRepository;
	}

}

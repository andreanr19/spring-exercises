package co.edu.icesi.ci.junit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.ci.junit.spring.model.UserOrder;

public interface UserOrderRepository extends CrudRepository<Integer, UserOrder> {

	public void delete(UserOrder uO);
	public UserOrder findById(int userOrderId);
	public void save(UserOrder newOrder);
	
}

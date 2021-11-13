package co.edu.icesi.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.model.prod.Product;

public interface ProductRepositoryInterface extends CrudRepository<Product, Integer> {
    
}

package co.edu.icesi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.model.prod.Productsubcategory;

public interface ProductSubcategoryRepositoryInterface extends CrudRepository<Productsubcategory, Integer>{
    
}

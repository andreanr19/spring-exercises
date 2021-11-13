package co.edu.icesi.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.model.prchasing.Productvendor;
import co.edu.icesi.model.prchasing.ProductvendorPK;

public interface ProductVendorRepositoryInterface extends CrudRepository<Productvendor,ProductvendorPK> {
    
}

package co.edu.icesi.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.model.prod.Productdocument;
import co.edu.icesi.model.prod.ProductdocumentPK;

public interface ProductDocumentRepositoryInterface extends CrudRepository<Productdocument, ProductdocumentPK> {

}

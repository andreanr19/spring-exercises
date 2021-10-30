package co.edu.icesi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Autotransition;

@Repository
public interface AutotransitionRepositoryI extends CrudRepository<Autotransition, Long>{
	
}

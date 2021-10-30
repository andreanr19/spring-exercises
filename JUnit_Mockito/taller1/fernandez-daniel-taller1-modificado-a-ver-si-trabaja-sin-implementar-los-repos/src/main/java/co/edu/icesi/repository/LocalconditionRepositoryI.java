package co.edu.icesi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Localcondition;

@Repository
public interface LocalconditionRepositoryI extends CrudRepository<Localcondition, Long>{

}

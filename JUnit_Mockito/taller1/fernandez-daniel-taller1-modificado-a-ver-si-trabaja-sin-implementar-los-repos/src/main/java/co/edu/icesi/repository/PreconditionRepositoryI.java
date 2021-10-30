package co.edu.icesi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Precondition;

@Repository
public interface PreconditionRepositoryI extends CrudRepository<Precondition, Long> {

}

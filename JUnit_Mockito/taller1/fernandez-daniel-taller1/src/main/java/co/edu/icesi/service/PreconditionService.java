package co.edu.icesi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.Precondition;
import co.edu.icesi.repository.PreconditionRepositoryI;

@Service
public class PreconditionService {


	private PreconditionRepositoryI preconditionRepository;
	
	public PreconditionService(PreconditionRepositoryI preconditionRepository) {
		this.preconditionRepository = preconditionRepository;
	}
	
	
	public <S extends Precondition> S save(S preotransition) {
		preconditionRepository.save(preotransition);
		return preotransition;
	}

	
	public <S extends Precondition> Iterable<S> saveAll(Iterable<S> pres) {
		for(Precondition pre : pres) {
			save(pre);
		}
		return pres;
	}

	
	public Optional<Precondition> findById(Long id) {
		return preconditionRepository.findById(id);
	}

	
	public boolean existsById(Long id) {
		return preconditionRepository.existsById(id);
	}

	
	public Iterable<Precondition> findAll() {
		return preconditionRepository.findAll();
	}

	
	public Iterable<Precondition> findAllById(Iterable<Long> ids) {
		return preconditionRepository.findAllById(ids);
	}

	
	public long count() {
		return preconditionRepository.count();
	}

	
	public void deleteById(Long id) {
		preconditionRepository.deleteById(id);
	}

	
	public void delete(Precondition preotransition) {
		preconditionRepository.delete(preotransition);
	}

	
	public void deleteAll(Iterable<? extends Precondition> pres) {
		preconditionRepository.deleteAll(pres);
	}

	public void deleteAll() {
		preconditionRepository.deleteAll();
	}

	public void editPrecondition(long id, String logicalOperand) {
		if(!logicalOperand.equals("AND") && !logicalOperand.equals("OR")) {
			throw new IllegalArgumentException("One of the arguments is not valid");
		}
		Precondition pre = findById(id).get();
		pre.setPreconLogicaloperand(logicalOperand);
	}
}

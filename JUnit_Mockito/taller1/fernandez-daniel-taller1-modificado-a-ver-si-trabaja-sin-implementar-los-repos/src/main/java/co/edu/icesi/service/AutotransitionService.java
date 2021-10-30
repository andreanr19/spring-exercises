package co.edu.icesi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.Autotransition;
import co.edu.icesi.repository.AutotransitionRepositoryI;

@Service
public class AutotransitionService {

	private AutotransitionRepositoryI autotransitionRepository;

	public AutotransitionService(AutotransitionRepositoryI autotransitionRepository) {
		this.autotransitionRepository = autotransitionRepository;
	}
	
	
	public <S extends Autotransition> S save(S autotransition) {
		autotransitionRepository.save(autotransition);
		return autotransition;
	}

	
	public <S extends Autotransition> Iterable<S> saveAll(Iterable<S> auts) {
		for(Autotransition aut : auts) {
			save(aut);
		}
		return auts;
	}

	
	public Optional<Autotransition> findById(Long id) {
		return autotransitionRepository.findById(id);
	}

	
	public boolean existsById(Long id) {
		return autotransitionRepository.existsById(id);
	}

	
	public Iterable<Autotransition> findAll() {
		return autotransitionRepository.findAll();
	}

	
	public Iterable<Autotransition> findAllById(Iterable<Long> ids) {
		return autotransitionRepository.findAllById(ids);
	}

	
	public long count() {
		return autotransitionRepository.count();
	}

	
	public void deleteById(Long id) {
		autotransitionRepository.deleteById(id);
	}

	
	public void delete(Autotransition autotransition) {
		autotransitionRepository.delete(autotransition);
	}

	
	public void deleteAll(Iterable<? extends Autotransition> auts) {
		autotransitionRepository.deleteAll(auts);
	}

	
	public void deleteAll() {
		autotransitionRepository.deleteAll();
	}

	public void editAutotransition(long id, String isActive, String logicalOperand, String name) {
		if(!isActive.equals("Y") && !isActive.equals("N") ||
				!logicalOperand.equals("OR") && !logicalOperand.equals("AND") ||
				name.isEmpty()) {
			throw new IllegalArgumentException("One of the arguments is not valid");
		}
		Autotransition aut = findById(id).get();
		aut.setAutotranIsactive(isActive);
		aut.setAutotranLogicaloperand(logicalOperand);
		aut.setAutotranName(name);
		save(aut); // Agrego esto porque sino en las pruebas de integracion el cambio no se hace y es raro, SPRING ES RARO
	}
}

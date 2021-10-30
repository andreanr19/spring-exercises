package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Precondition;

@Repository
public class PreconditionRepositoryImpl implements PreconditionRepositoryI {
	Map<Long, Precondition> preconditions;
	
	public PreconditionRepositoryImpl() {
		preconditions = new HashMap<>();
	}
	
	@Override
	public <S extends Precondition> S save(S precondition) {
		preconditions.put(precondition.getPreconId(), precondition);
		return precondition;
	}

	@Override
	public <S extends Precondition> Iterable<S> saveAll(Iterable<S> preConds) {
		for(Precondition preCond : preConds) {
			save(preCond);
		}
		return preConds;
	}

	@Override
	public Optional<Precondition> findById(Long id) {
		return Optional.of(preconditions.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return preconditions.containsKey(id);
	}

	@Override
	public Iterable<Precondition> findAll() {
		return preconditions.values();
	}

	@Override
	public Iterable<Precondition> findAllById(Iterable<Long> ids) {
		ArrayList<Precondition> preConds = new ArrayList<>();
		for(Long id : ids) {
			Optional<Precondition> op = findById(id);
			if(!op.isEmpty()) {
				preConds.add(op.get());
			}
		}
		return preConds;
	}

	@Override
	public long count() {
		return preconditions.size();
	}

	@Override
	public void deleteById(Long id) {
		preconditions.remove(id);
	}

	@Override
	public void delete(Precondition precondition) {
		preconditions.remove(precondition.getPreconId(), precondition);
	}

	@Override
	public void deleteAll(Iterable<? extends Precondition> preConds) {
		for(Precondition preCond : preConds) {
			delete(preCond);
		}
	}

	@Override
	public void deleteAll() {
		for(Precondition preCond : preconditions.values()) {
			delete(preCond);
		}
	}
}

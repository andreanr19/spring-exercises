package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Localcondition;

//@Repository
public class LocalconditionRepositoryImpl implements LocalconditionRepositoryI {


	Map<Long, Localcondition> localconditions;

	public LocalconditionRepositoryImpl() {
		localconditions = new HashMap<>();
	}

	@Override
	public <S extends Localcondition> S save(S localcondition) {
		localconditions.put(localcondition.getLoconId(), localcondition);
		return localcondition;
	}

	@Override
	public <S extends Localcondition> Iterable<S> saveAll(Iterable<S> localConds) {
		for(Localcondition localCond : localConds) {
			save(localCond);
		}
		return localConds;
	}

	@Override
	public Optional<Localcondition> findById(Long id) {
		return Optional.of(localconditions.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return localconditions.containsKey(id);
	}

	@Override
	public Iterable<Localcondition> findAll() {
		return localconditions.values();
	}

	@Override
	public Iterable<Localcondition> findAllById(Iterable<Long> ids) {
		ArrayList<Localcondition> localConds = new ArrayList<>();
		for(Long id : ids) {
			Optional<Localcondition> op = findById(id);
			if(!op.isEmpty()) {
				localConds.add(op.get());
			}
		}
		return localConds;
	}

	@Override
	public long count() {
		return localconditions.size();
	}

	@Override
	public void deleteById(Long id) {
		localconditions.remove(id);
	}

	@Override
	public void delete(Localcondition localcondition) {
		localconditions.remove(localcondition.getLoconId(), localcondition);
	}

	@Override
	public void deleteAll(Iterable<? extends Localcondition> localConds) {
		for(Localcondition localCond : localConds) {
			delete(localCond);
		}
	}

	@Override
	public void deleteAll() {
		for(Localcondition localCond : localconditions.values()) {
			delete(localCond);
		}
	}

}

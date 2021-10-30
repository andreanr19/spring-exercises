package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Autotransition;

//@Repository
public class AutotransitionRepositoryImpl implements AutotransitionRepositoryI {
	Map<Long, Autotransition> autotransitions;
	
	public AutotransitionRepositoryImpl() {
		autotransitions = new HashMap<>();
	}
	
	@Override
	public <S extends Autotransition> S save(S autotransition) {
		autotransitions.put(autotransition.getAutotranId(), autotransition);
		return autotransition;
	}

	@Override
	public <S extends Autotransition> Iterable<S> saveAll(Iterable<S> auts) {
		for(Autotransition aut : auts) {
			save(aut);
		}
		return auts;
	}

	@Override
	public Optional<Autotransition> findById(Long id) {
		return Optional.of(autotransitions.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return autotransitions.containsKey(id);
	}

	@Override
	public Iterable<Autotransition> findAll() {
		return autotransitions.values();
	}

	@Override
	public Iterable<Autotransition> findAllById(Iterable<Long> ids) {
		ArrayList<Autotransition> auts = new ArrayList<>();
		for(Long id : ids) {
			Optional<Autotransition> op = findById(id);
			if(!op.isEmpty()) {
				auts.add(op.get());
			}
		}
		return auts;
	}

	@Override
	public long count() {
		return autotransitions.size();
	}

	@Override
	public void deleteById(Long id) {
		autotransitions.remove(id);
	}

	@Override
	public void delete(Autotransition autotransition) {
		autotransitions.remove(autotransition.getAutotranId(), autotransition);
	}

	@Override
	public void deleteAll(Iterable<? extends Autotransition> auts) {
		for(Autotransition aut : auts) {
			delete(aut);
		}
	}

	@Override
	public void deleteAll() {
		for(Autotransition aut : autotransitions.values()) {
			delete(aut);
		}
	}

}

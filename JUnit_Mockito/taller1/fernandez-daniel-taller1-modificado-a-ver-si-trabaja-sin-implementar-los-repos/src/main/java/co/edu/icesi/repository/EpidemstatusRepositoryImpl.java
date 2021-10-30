package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Epidemstatus;

//@Repository
public class EpidemstatusRepositoryImpl implements EpidemstatusRepositoryI {

	Map<Long, Epidemstatus> epidemstatuses;
	
	public EpidemstatusRepositoryImpl() {
		epidemstatuses = new HashMap<>();
	}
	
	@Override
	public <S extends Epidemstatus> S save(S epidemstatus) {
		epidemstatuses.put(epidemstatus.getEpistatId(), epidemstatus);
		return epidemstatus;
	}

	@Override
	public <S extends Epidemstatus> Iterable<S> saveAll(Iterable<S> epidStats) {
		for(Epidemstatus ins : epidStats) {
			save(ins);
		}
		return epidStats;
	}

	@Override
	public Optional<Epidemstatus> findById(Long id) {
		return Optional.of(epidemstatuses.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return epidemstatuses.containsKey(id);
	}

	@Override
	public Iterable<Epidemstatus> findAll() {
		return epidemstatuses.values();
	}

	@Override
	public Iterable<Epidemstatus> findAllById(Iterable<Long> ids) {
		ArrayList<Epidemstatus> auts = new ArrayList<>();
		for(Long id : ids) {
			Optional<Epidemstatus> op = findById(id);
			if(!op.isEmpty()) {
				auts.add(op.get());
			}
		}
		return auts;
	}

	@Override
	public long count() {
		return epidemstatuses.size();
	}

	@Override
	public void deleteById(Long id) {
		epidemstatuses.remove(id);
	}

	@Override
	public void delete(Epidemstatus epidemstatus) {
		epidemstatuses.remove(epidemstatus.getEpistatId(), epidemstatus);
	}

	@Override
	public void deleteAll(Iterable<? extends Epidemstatus> auts) {
		for(Epidemstatus aut : auts) {
			delete(aut);
		}
	}

	@Override
	public void deleteAll() {
		for(Epidemstatus aut : epidemstatuses.values()) {
			delete(aut);
		}
	}
}

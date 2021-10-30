package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Institution;

@Repository
public class InstitutionRepositoryImpl implements InstitutionRepositoryI {
	Map<Long, Institution> institutions;
	
	public InstitutionRepositoryImpl() {
		institutions = new HashMap<>();
	}
	
	@Override
	public <S extends Institution> S save(S institution) {
		institutions.put(institution.getInstId(), institution);
		return institution;
	}

	@Override
	public <S extends Institution> Iterable<S> saveAll(Iterable<S> insts) {
		for(Institution ins : insts) {
			save(ins);
		}
		return insts;
	}

	@Override
	public Optional<Institution> findById(Long id) {
		return Optional.of(institutions.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return institutions.containsKey(id);
	}

	@Override
	public Iterable<Institution> findAll() {
		return institutions.values();
	}

	@Override
	public Iterable<Institution> findAllById(Iterable<Long> ids) {
		ArrayList<Institution> auts = new ArrayList<>();
		for(Long id : ids) {
			Optional<Institution> op = findById(id);
			if(!op.isEmpty()) {
				auts.add(op.get());
			}
		}
		return auts;
	}

	@Override
	public long count() {
		return institutions.size();
	}

	@Override
	public void deleteById(Long id) {
		institutions.remove(id);
	}

	@Override
	public void delete(Institution institution) {
		institutions.remove(institution.getInstId(), institution);
	}

	@Override
	public void deleteAll(Iterable<? extends Institution> auts) {
		for(Institution aut : auts) {
			delete(aut);
		}
	}

	@Override
	public void deleteAll() {
		for(Institution aut : institutions.values()) {
			delete(aut);
		}
	}
}

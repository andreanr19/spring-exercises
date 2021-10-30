package co.edu.icesi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.Threshold;

@Repository
public class ThresholdRepositoryImpl implements ThresholdRepositoryI {

	Map<Long, Threshold> thresholds;

	public ThresholdRepositoryImpl() {
		thresholds = new HashMap<>();
	}

	@Override
	public <S extends Threshold> S save(S threshold) {
		thresholds.put(threshold.getThresId(), threshold);
		return threshold;
	}

	@Override
	public <S extends Threshold> Iterable<S> saveAll(Iterable<S> thrshlds) {
		for(Threshold thrshld : thrshlds) {
			save(thrshld);
		}
		return thrshlds;
	}

	@Override
	public Optional<Threshold> findById(Long id) {
		return Optional.of(thresholds.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return thresholds.containsKey(id);
	}

	@Override
	public Iterable<Threshold> findAll() {
		return thresholds.values();
	}

	@Override
	public Iterable<Threshold> findAllById(Iterable<Long> ids) {
		ArrayList<Threshold> thrshlds = new ArrayList<>();
		for(Long id : ids) {
			Optional<Threshold> op = findById(id);
			if(!op.isEmpty()) {
				thrshlds.add(op.get());
			}
		}
		return thrshlds;
	}

	@Override
	public long count() {
		return thresholds.size();
	}

	@Override
	public void deleteById(Long id) {
		thresholds.remove(id);
	}

	@Override
	public void delete(Threshold threshold) {
		thresholds.remove(threshold.getThresId(), threshold);
	}

	@Override
	public void deleteAll(Iterable<? extends Threshold> thrshlds) {
		for(Threshold thrshld : thrshlds) {
			delete(thrshld);
		}
	}

	@Override
	public void deleteAll() {
		for(Threshold thrshld : thresholds.values()) {
			delete(thrshld);
		}
	}
}

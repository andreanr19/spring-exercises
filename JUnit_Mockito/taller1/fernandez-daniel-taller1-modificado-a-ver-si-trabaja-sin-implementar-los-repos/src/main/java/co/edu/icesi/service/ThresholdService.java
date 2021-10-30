package co.edu.icesi.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.Threshold;
import co.edu.icesi.repository.ThresholdRepositoryI;

@Service
public class ThresholdService {
	private ThresholdRepositoryI thresholdRepository;
	
	public ThresholdService(ThresholdRepositoryI thresholdRepository) {
		this.thresholdRepository = thresholdRepository;
	}
	
	
	public <S extends Threshold> S save(S threshold) {
		thresholdRepository.save(threshold);
		return threshold;
	}

	
	public <S extends Threshold> Iterable<S> saveAll(Iterable<S> thrs) {
		for(Threshold thr : thrs) {
			save(thr);
		}
		return thrs;
	}

	
	public Optional<Threshold> findById(Long id) {
		return thresholdRepository.findById(id);
	}

	
	public boolean existsById(Long id) {
		return thresholdRepository.existsById(id);
	}

	
	public Iterable<Threshold> findAll() {
		return thresholdRepository.findAll();
	}

	
	public Iterable<Threshold> findAllById(Iterable<Long> ids) {
		return thresholdRepository.findAllById(ids);
	}

	
	public long count() {
		return thresholdRepository.count();
	}

	
	public void deleteById(Long id) {
		thresholdRepository.deleteById(id);
	}

	
	public void delete(Threshold threshold) {
		thresholdRepository.delete(threshold);
	}

	
	public void deleteAll(Iterable<? extends Threshold> thrs) {
		thresholdRepository.deleteAll(thrs);
	}

	
	public void deleteAll() {
		thresholdRepository.deleteAll();
	}

	public void editThreshold(long id, BigDecimal instid, String name, String value, String vtype) {
		if(name.isEmpty() || value.isEmpty()) {
			throw new IllegalArgumentException("One of the arguments is not valid");
		}
		
		Threshold thr = findById(id).get();
		thr.setInstInstId(instid);
		thr.setThresName(name);
		thr.setThresValue(value);
		thr.setThresValuetype(vtype);
		save(thr); // Agrego esto porque sino en las pruebas de integracion el cambio no se hace y es raro, SPRING ES RARO
	}
}

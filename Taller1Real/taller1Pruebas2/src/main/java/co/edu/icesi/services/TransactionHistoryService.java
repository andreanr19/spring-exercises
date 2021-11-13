package co.edu.icesi.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.Productvendor;
import co.edu.icesi.model.ProductvendorPK;
import co.edu.icesi.model.Transactionhistory;
import co.edu.icesi.repositories.ProductVendorRepositoryInterface;
import co.edu.icesi.repositories.TransactionHistoryRepositoryInterface;

@Service
public class TransactionHistoryService {

	private TransactionHistoryRepositoryInterface transactionHistoryRepository;

	public TransactionHistoryService(TransactionHistoryRepositoryInterface transactionHistoryRepository) {
		this.transactionHistoryRepository = transactionHistoryRepository;
	}

	public <S extends Transactionhistory> S save(S transactionhistory) {

//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		Date ahora = new Date();
//		df.format(ahora);
//
//		long time = ahora.getTime();
		long time= System.currentTimeMillis();
		Timestamp actualdate = new Timestamp(time);
		if (!(transactionhistory.getQuantity() > 0)
				|| (transactionhistory.getActualcost().compareTo(new BigDecimal("0")) == -1)
				|| (transactionhistory.getActualcost().compareTo(new BigDecimal("0")) == 0)
				||  (Math.abs(actualdate.compareTo(transactionhistory.getTransactiondate()))> 5)) {
			
			if(!(transactionhistory.getQuantity() > 0)){
				throw new IllegalArgumentException("Quantity should be greater than 0");
			}else if(transactionhistory.getActualcost().compareTo(new BigDecimal("0")) == -1) {
				throw new IllegalArgumentException("The cost shouldn't be less than 0");
			}else if (transactionhistory.getActualcost().compareTo(new BigDecimal("0")) == 0) {
				throw new IllegalArgumentException("The cost shouldn't be 0");

			}else if(!(actualdate.compareTo(transactionhistory.getTransactiondate())==0)){
				System.out.println(actualdate);
				System.out.println(transactionhistory.getTransactiondate());

				throw new IllegalArgumentException("transaction history date should be the actual date ");

			}
			

		}
		transactionHistoryRepository.save(transactionhistory);
		return transactionhistory;
	}

	public <S extends Transactionhistory> Iterable<S> saveAll(Iterable<S> ths) {
		for (Transactionhistory th : ths) {
			save(th);
		}
		return ths;
	}

	public Optional<Transactionhistory> findById(Integer id) {
		return transactionHistoryRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return transactionHistoryRepository.existsById(id);
	}

	public Iterable<Transactionhistory> findAll() {
		return transactionHistoryRepository.findAll();
	}

	public Iterable<Transactionhistory> findAllById(Iterable<Integer> ids) {
		return transactionHistoryRepository.findAllById(ids);
	}

	public long count() {
		return transactionHistoryRepository.count();
	}

	public void deleteById(Integer id) {
		transactionHistoryRepository.deleteById(id);
	}

	public void delete(Transactionhistory transactionhistory) {
		transactionHistoryRepository.delete(transactionhistory);
	}

	public void deleteAll(Iterable<? extends Transactionhistory> ths) {
		transactionHistoryRepository.deleteAll(ths);
	}

	public void deleteAll() {
		transactionHistoryRepository.deleteAll();
	}

	public void editTransactionHistory(Integer id, BigDecimal actualcost, Timestamp modifieddate, Integer quantity,
			Integer refereceorderid, Integer referencerorderlineid, Timestamp transactiondate, String trasactiontype) {

//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		Date ahora = new Date();
//		df.format(ahora);
//
//		long time = ahora.getTime();
		long time= System.currentTimeMillis();
		
		
		Timestamp actualdate = new Timestamp(time);
		System.out.println(actualdate +"," + transactiondate);
		if (!(quantity > 0) || (actualcost.compareTo(new BigDecimal("0")) == -1)
				|| (actualcost.compareTo(new BigDecimal("0")) == 0) || (Math.abs(actualdate.compareTo(transactiondate))> 5)) {
			System.out.println(actualdate);
			System.out.println(transactiondate);
			throw new IllegalArgumentException("One argument is invalid");

		}
		Transactionhistory th = transactionHistoryRepository.findById(id).get();
		th.setActualcost(actualcost);
		th.setModifieddate(modifieddate);
		th.setQuantity(quantity);
		th.setReferenceorderid(refereceorderid);
		th.setReferenceorderlineid(referencerorderlineid);
		th.setTransactiondate(transactiondate);
		th.setTransactiontype(trasactiontype);
		save(th);
	}

}

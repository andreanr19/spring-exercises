package co.edu.icesi.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.prod.Product;
import co.edu.icesi.model.prod.Productcategory;
import co.edu.icesi.model.prod.Productsubcategory;
import co.edu.icesi.model.prod.Unitmeasure;
import co.edu.icesi.repositories.ProductRepositoryInterface;

@Service
public class ProductService {

	ProductRepositoryInterface productRepository;

	public ProductService(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
	}

	public <S extends Product> S save(S product) {
		if (product.getProductnumber().isEmpty() || !product.getSellstartdate().before(product.getSellenddate())
				|| !(product.getDaystomanufacture() > 0)) {

			if (product.getProductnumber().isEmpty()) {
				throw new IllegalArgumentException("The product number argument shouldn't be empty");
			} else if (!product.getSellstartdate().before(product.getSellenddate())) {
				throw new IllegalArgumentException(
						"Product sell end date should be greater than product sell start date");
			} else {
				throw new IllegalArgumentException("Product's days to manufacture should be greater than 0");
			}

		}
		productRepository.save(product);
		return product;
	}

	public <S extends Product> Iterable<S> saveAll(Iterable<S> ps) {
		for (Product p : ps) {
			save(p);
		}
		return ps;
	}

	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return productRepository.existsById(id);
	}

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Iterable<Product> findAllById(Iterable<Integer> ids) {
		return productRepository.findAllById(ids);
	}

	public long count() {
		return productRepository.count();
	}

	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public void deleteAll(Iterable<? extends Product> ps) {
		productRepository.deleteAll(ps);
	}

	public void deleteAll() {
		productRepository.deleteAll();
	}

	public void editProduct(Integer id, String class_, String color, Integer daystomanufacture,
			Timestamp discontinueddate, String finishedgoodsflag, BigDecimal listprice, String makeflag,
			Timestamp modifieddate, String name, String productline, String productnumber, Integer reorderpoint,
			Integer rowguid, Integer safetystocklevel, Timestamp sellenddate, Timestamp sellstartdate, String size,
			BigDecimal standardcost, String style, BigDecimal weight, Productsubcategory psc, Productcategory pc,
			Unitmeasure um1, Unitmeasure um2) {

		if (productnumber.isEmpty() || !sellstartdate.before(sellenddate) || !(daystomanufacture > 0)) {
			throw new IllegalArgumentException("One argument is invalid");

		}
		Product p = findById(id).get();
		p.setClass_(class_);
		p.setColor(color);
		p.setDaystomanufacture(daystomanufacture);
		p.setDiscontinueddate(discontinueddate);
		p.setFinishedgoodsflag(finishedgoodsflag);
		p.setListprice(listprice);
		p.setMakeflag(makeflag);
		p.setModifieddate(modifieddate);
		p.setName(name);
		p.setProductline(productline);
		p.setProductnumber(productnumber);
		p.setReorderpoint(reorderpoint);
		p.setRowguid(rowguid);
		p.setSafetystocklevel(safetystocklevel);
		p.setSellenddate(sellenddate);
		p.setSellstartdate(sellstartdate);
		p.setSize(size);
		p.setStandardcost(standardcost);
		p.setStyle(style);
		p.setWeight(weight);
		save(p);
	}

	public void editProduct2(Product product) {

		if (product.getProductnumber().isEmpty() || !product.getSellstartdate().before(product.getSellenddate())
				|| !(product.getDaystomanufacture() > 0)) {
			throw new IllegalArgumentException("One argument is invalid");

		}
		Product productEntity = findById(product.getProductid()).get();
		productEntity.setClass_(product.getClass_());
		productEntity.setColor(product.getColor());
		productEntity.setDaystomanufacture(product.getDaystomanufacture());
		productEntity.setDiscontinueddate(product.getDiscontinueddate());
		productEntity.setFinishedgoodsflag(product.getFinishedgoodsflag());
		productEntity.setListprice(product.getListprice());
		productEntity.setMakeflag(product.getMakeflag());
		productEntity.setModifieddate(product.getModifieddate());
		productEntity.setName(product.getName());
		productEntity.setProductline(product.getProductline());
		productEntity.setProductnumber(product.getProductnumber());
		productEntity.setReorderpoint(product.getReorderpoint());
		productEntity.setRowguid(product.getRowguid());
		productEntity.setSafetystocklevel(product.getSafetystocklevel());
		productEntity.setSellenddate(product.getSellenddate());
		productEntity.setSellstartdate(product.getSellenddate());
		productEntity.setSize(product.getSize());
		productEntity.setStandardcost(product.getStandardcost());
		productEntity.setStyle(product.getStyle());
		productEntity.setWeight(product.getWeight());
		save(productEntity);
	}
}

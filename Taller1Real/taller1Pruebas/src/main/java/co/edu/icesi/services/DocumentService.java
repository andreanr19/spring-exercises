package co.edu.icesi.services;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.prod.Document;
import co.edu.icesi.repositories.DocumentRepositoryInterface;

@Service
public class DocumentService {

	DocumentRepositoryInterface documentRepository;

	public DocumentService(DocumentRepositoryInterface documentRepository) {
		this.documentRepository = documentRepository;
	}

	public <S extends Document> S save(S document) {
		documentRepository.save(document);
		return document;
	}

	public <S extends Document> Iterable<S> saveAll(Iterable<S> documents) {
		for (Document doc : documents) {
			save(doc);
		}
		return documents;
	}

	public Optional<Document> findById(String id) {
		return documentRepository.findById(id);
	}

	public boolean existsById(String id) {
		return documentRepository.existsById(id);
	}

	public Iterable<Document> findAll() {
		return documentRepository.findAll();
	}

	public Iterable<Document> findAllById(Iterable<String> theids) {
		return documentRepository.findAllById(theids);
	}

	public long count() {
		return documentRepository.count();
	}

	public void deleteAll() {
		documentRepository.deleteAll();
	}

	public void delete(Document doc) {
		documentRepository.delete(doc);
	}

	public void deleteAll(Iterable<? extends Document> docs) {
		documentRepository.deleteAll(docs);
	}

	public void deleteById(String id) {
		documentRepository.deleteById(id);
	}

	public void editDocument(String id, Integer changenumber, byte[] document, String documentsummary,
			String fileextension, String filename, String folderflag, Timestamp modifieddate, Integer owner,
			String revision, Integer rowguid, Integer status, String title) {
		
		if((filename.length()<4) || (fileextension.length()<3) ) {
			throw new IllegalArgumentException("Invalid argument");
		}
		Document d = documentRepository.findById(id).get();
		d.setChangenumber(changenumber);
		d.setDocument(document);
		d.setDocumentsummary(documentsummary);
		d.setFileextension(fileextension);
		d.setFilename(filename);
		d.setFolderflag(folderflag);
		d.setModifieddate(modifieddate);
		d.setOwner(owner);
		d.setRevision(revision);
		d.setRowguid(rowguid);
		d.setStatus(status);
		d.setTitle(title);
		
		save(d);
	}
}






















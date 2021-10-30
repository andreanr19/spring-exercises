package co.edu.icesi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.icesi.model.Institution;
import co.edu.icesi.repository.InstitutionRepositoryI;

@Service
public class InstitutionService {

	private InstitutionRepositoryI institutionRepository;
	
	public InstitutionService(InstitutionRepositoryI institutionRepository) {
		this.institutionRepository = institutionRepository;
	}
	
	public <S extends Institution> S save(S instotransition) {
		institutionRepository.save(instotransition);
		return instotransition;
	}
	
	public <S extends Institution> Iterable<S> saveAll(Iterable<S> insts) {
		for(Institution inst : insts) {
			save(inst);
		}
		return insts;
	}

	public Optional<Institution> findById(Long id) {
		return institutionRepository.findById(id);
	}
	
	public boolean existsById(Long id) {
		return institutionRepository.existsById(id);
	}

	public Iterable<Institution> findAll() {
		return institutionRepository.findAll();
	}

	public Iterable<Institution> findAllById(Iterable<Long> ids) {
		return institutionRepository.findAllById(ids);
	}

	public long count() {
		return institutionRepository.count();
	}

	public void deleteById(Long id) {
		institutionRepository.deleteById(id);
	}

	public void delete(Institution instotransition) {
		institutionRepository.delete(instotransition);
	}

	public void deleteAll(Iterable<? extends Institution> insts) {
		institutionRepository.deleteAll(insts);
	}

	public void deleteAll() {
		institutionRepository.deleteAll();
	}

	public void editInstitution(long id, String academicServerUrl, String acadextradataurl, String acadloginpassword, String acadloginurl
			, String acadloginusername, String acadpersoninfodocurl, String acadpersoninfoidurl, String acadphysicalspacesurl, String acadprogrammedcoursesurl
			, String ldapbasedn, String ldappassword, String ldapurl, String ldapusername, String ldapusersearchbase, String name) {
		Institution inst = findById(id).get();
		inst.setInstAcademicserverurl(academicServerUrl);
		inst.setInstAcadextradataurl(acadextradataurl);
		inst.setInstAcadloginpassword(acadloginpassword);
		inst.setInstAcadloginurl(acadloginurl);
		inst.setInstAcadloginusername(acadloginusername);
		inst.setInstAcadpersoninfodocurl(acadpersoninfodocurl);
		inst.setInstAcadpersoninfoidurl(acadpersoninfoidurl);
		inst.setInstAcadphysicalspacesurl(acadphysicalspacesurl);
		inst.setInstAcadprogrammedcoursesurl(acadprogrammedcoursesurl);
		inst.setInstLdapbasedn(ldapbasedn);
		inst.setInstLdappassword(ldappassword);
		inst.setInstLdapurl(ldapurl);
		inst.setInstLdapusername(ldapusername);
		inst.setInstLdapusersearchbase(ldapusersearchbase);
		inst.setInstName(name);
	}
}

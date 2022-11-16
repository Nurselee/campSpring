package kodlama.io.programmingLanguage.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguage.business.abstracts.LanguageService;
import kodlama.io.programmingLanguage.business.abstracts.TechnologyService;
import kodlama.io.programmingLanguage.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguage.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguage.business.responses.language.LanguageDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageListResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageResponse;
import kodlama.io.programmingLanguage.business.responses.language.UpdateLanguageResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyListResponse;
import kodlama.io.programmingLanguage.dataAccess.abstracts.LanguageDao;
import kodlama.io.programmingLanguage.entities.concretes.Language;
import kodlama.io.programmingLanguage.entities.concretes.Technology;


@Service
public class LanguageManager implements LanguageService{

	
	private LanguageDao languageDao;
	private TechnologyService technologyService;
	
	public LanguageManager(LanguageDao languageDao, TechnologyService technologyService) {
		
		this.languageDao = languageDao;
		this.technologyService = technologyService;
	}

	@Override
	public LanguageResponse add(CreateLanguageRequest createLanguageRequest ) {
		
		checkIfNameDuplicated(createLanguageRequest.getName());
		checkIfNameIsEmptyOrNull(createLanguageRequest.getName());
		Language language = new Language();
		language.setId(0);
		language.setName(createLanguageRequest.getName());
		List<Technology> technologies = new ArrayList();
		for (Integer technologyId : createLanguageRequest.getTechnologyIds()) {
			Technology technology = this.technologyService.getTechnologyById(technologyId);
			technologies.add(technology);
		}
		
		language.setTechnologies(technologies);
		LanguageResponse languageResponse = new LanguageResponse();

		languageResponse.setName(language.getName());

		this.languageDao.save(language);
		
		return languageResponse;
	}
	
	private void checkIfNameDuplicated(String name){
		if(this.languageDao.existsByNameContainingIgnoreCase(name)) {
			throw new RuntimeException("Name already exists");
		}
	}

	private void checkIfNameIsEmptyOrNull(String name){
		if(name.isBlank() || name.isEmpty() || Objects.isNull(name)) {
			throw new RuntimeException("Name cannot be null or empty");
		}
	}
	@Override
	public List<LanguageListResponse> getAll() {
		
		List<Language> languages = this.languageDao.findAll();
		List<LanguageListResponse> languageListResponses = new ArrayList<>();
		
		for (Language language : languages) {
			LanguageListResponse languageListResponse = new LanguageListResponse();
			languageListResponse.setId(language.getId());
			languageListResponse.setName(language.getName());
			List<TechnologyListResponse> technologyListResponses = new ArrayList<>();
			for (Technology technology : language.getTechnologies()) {
				TechnologyListResponse technologyListResponse = new TechnologyListResponse();
				technologyListResponse.setId(technology.getId());
				technologyListResponse.setName(technology.getName());
				technologyListResponses.add(technologyListResponse);
			}
			
			languageListResponse.setTechnologies(technologyListResponses);
			languageListResponses.add(languageListResponse);
			
		
		}
		
		return languageListResponses;
		
		
	}
	

	@Override
	public LanguageDeleteResponse delete(int id) {
		
		checkIfIdExists(id);
		Language language = this.languageDao.findById(id).get();
		LanguageDeleteResponse languageDeleteResponse = new LanguageDeleteResponse();
		languageDeleteResponse.setName(language.getName());
		this.languageDao.deleteById(id);
		return languageDeleteResponse;
	}

	@Override
	public UpdateLanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) {
		
		checkIfIdExists(id);
		checkIfNameDuplicated(updateLanguageRequest.getName());
		checkIfNameIsEmptyOrNull(updateLanguageRequest.getName());
		UpdateLanguageResponse updateLanguageResponse = new UpdateLanguageResponse();
		
		Language language = this.languageDao.findById(id).get();
		updateLanguageResponse.setNewName(updateLanguageRequest.getName());
		updateLanguageResponse.setOldName(language.getName());
		language.setName(updateLanguageRequest.getName());
		
		this.languageDao.save(language);
		return updateLanguageResponse;
	}

	
	private void checkIfIdExists(int id) {
		if(!this.languageDao.existsById(id)) {
			throw new RuntimeException("Id does not exist");
		}
	}
	@Override
	public LanguageResponse getById(int id){
		
		checkIfIdExists(id);
		Language language = this.languageDao.findById(id).get();
		
		LanguageResponse languageResponse = new LanguageResponse();
		languageResponse.setName(language.getName());
		return languageResponse;
		
	}

}

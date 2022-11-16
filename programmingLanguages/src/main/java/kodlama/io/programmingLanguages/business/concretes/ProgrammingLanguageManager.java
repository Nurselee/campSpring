package kodlama.io.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programmingLanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLanguages.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;
import kodlama.io.programmingLanguages.entities.concretes.Technologies;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programminLanguageRepository) {
		
		this.programmingLanguageRepository = programminLanguageRepository;
	}



	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		// business rules
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();

        for (ProgrammingLanguage programmingLanguage: programmingLanguages) {
        	GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());
            responseItem.setTechnologies(programmingLanguage.getTechnologies());
            programmingLanguagesResponse.add(responseItem);
        }
        return programmingLanguagesResponse;
	}


	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		// TODO Auto-generated method stub
		List<Technologies> technologies = new ArrayList<Technologies>();
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(deleteProgrammingLanguageRequest.getId()).get(); 
		programmingLanguage.setTechnologies(technologies);
		this.programmingLanguageRepository.save(programmingLanguage);
		
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
		
	}
	



	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguage);
		
	}

//	@Override
//	public ProgrammingLanguage getById(int id) {
//		// TODO Auto-generated method stub
//		return programmingLanguageRepository.getById(id);
//	}



	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, String name) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
	}

}


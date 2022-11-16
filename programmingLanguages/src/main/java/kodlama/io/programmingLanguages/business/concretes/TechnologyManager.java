package kodlama.io.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.TechnologyService;
import kodlama.io.programmingLanguages.business.requests.CreateTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateTechnologyRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllTechnologiesResponse;
import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLanguages.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;
import kodlama.io.programmingLanguages.entities.concretes.Technologies;



@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programminglanguageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,ProgrammingLanguageRepository programminglanguageRepository) {
		
		this.technologyRepository = technologyRepository;
		this.programminglanguageRepository = programminglanguageRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		// business rules
		List<Technologies> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = new ArrayList<GetAllTechnologiesResponse>();

		for (Technologies technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			
			technologiesResponse.add(responseItem);
			
		}
		return technologiesResponse;
	}
	


	@Override
	public void delete(DeleteTechnologyRequest deleteProgrammingLanguageRequest) {
		Technologies technologies = new Technologies();
		technologies.setId(deleteProgrammingLanguageRequest.getId());
		technologyRepository.delete(technologies);

	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		ProgrammingLanguage programmingLanguage=programminglanguageRepository.getReferenceById(createTechnologyRequest.getProgrammingLanguageId());
		Technologies technologies = new Technologies();
		technologies.setName(createTechnologyRequest.getName());
		
        this.technologyRepository.save(technologies);
		
	}
	

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, String name) {
		Optional<ProgrammingLanguage> language = programminglanguageRepository
				.findById(updateTechnologyRequest.getProgrammingLanguageId());
		Technologies technologies = new Technologies();
		technologies.setName(name);
		
		this.technologyRepository.save(technologies);

	}

	

}

package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.business.requests.CreateTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateTechnologyRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllTechnologiesResponse;


public interface TechnologyService {

	List<GetAllTechnologiesResponse> getAll();
	void delete(DeleteTechnologyRequest deleteProgrammingLanguageRequest);
	
	//ProgrammingLanguage getById(int id);
	void update(UpdateTechnologyRequest updateTechnologyRequest, String name);
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	
	
}

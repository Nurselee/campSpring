package kodlama.io.programmingLanguage.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguage.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.programmingLanguage.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyListResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyResponse;
import kodlama.io.programmingLanguage.business.responses.technology.UpdateTechnologyResponse;
import kodlama.io.programmingLanguage.entities.concretes.Technology;

public interface TechnologyService {

	TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest);
	List<TechnologyListResponse> getAll();
	TechnologyDeleteResponse delete(int id);
	UpdateTechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest);
	TechnologyResponse getById(int id);
	
	Technology getTechnologyById(int id);
	
}

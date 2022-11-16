package kodlama.io.programmingLanguage.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguage.business.abstracts.TechnologyService;
import kodlama.io.programmingLanguage.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.programmingLanguage.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyListResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyResponse;
import kodlama.io.programmingLanguage.business.responses.technology.UpdateTechnologyResponse;
import kodlama.io.programmingLanguage.dataAccess.abstracts.TechnologyDao;
import kodlama.io.programmingLanguage.entities.concretes.Technology;


@Service
public class TechnologyManager implements TechnologyService {

	
private TechnologyDao technologyDao;
	
	
	public TechnologyManager(TechnologyDao technologyDao) {
		
		this.technologyDao = technologyDao;
	}
	@Override
	public TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		TechnologyResponse technologyResponse = new TechnologyResponse();
	    technology.setId(0);
	    technology.setName(createTechnologyRequest.getName());
	    technologyResponse.setName(technology.getName());
	    this.technologyDao.save(technology);
	    return technologyResponse;
		
		
	}

	@Override
	public List<TechnologyListResponse> getAll() {
		List<Technology> technologyList = this.technologyDao.findAll();
	    List<TechnologyListResponse> technologyListResponses = new ArrayList<>();

	    for (Technology technology : technologyList) {
	      TechnologyListResponse technologyListResponse = new TechnologyListResponse();
	      technologyListResponse.setId(technology.getId());
	      technologyListResponse.setName(technology.getName());
	      technologyListResponses.add(technologyListResponse);
	    }
	    return technologyListResponses;
	}

	@Override
	public TechnologyDeleteResponse delete(int id) {
		
		Technology technology = this.technologyDao.findById(id).get();
		TechnologyDeleteResponse technologyDeleteResponse = new TechnologyDeleteResponse();
		technologyDeleteResponse.setName(technology.getName());
		this.technologyDao.deleteById(id);
		return technologyDeleteResponse;
	}

	@Override
	public UpdateTechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		UpdateTechnologyResponse updateTechnologyResponse = new UpdateTechnologyResponse();
		
		Technology technology = this.technologyDao.findById(id).get();
		updateTechnologyResponse.setNewName(updateTechnologyRequest.getName());
		updateTechnologyResponse.setOldName(technology.getName());
		technology.setName(updateTechnologyRequest.getName());
		
		this.technologyDao.save(technology);
		return updateTechnologyResponse;
	}

	@Override
	public TechnologyResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Technology getTechnologyById(int id) {
		
		Technology technology = this.technologyDao.findById(id).get();
		return technology;
		
	}

}

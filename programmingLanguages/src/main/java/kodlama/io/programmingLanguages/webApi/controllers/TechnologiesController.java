package kodlama.io.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.TechnologyService;
import kodlama.io.programmingLanguages.business.requests.CreateTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteTechnologyRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateTechnologyRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		
		this.technologyService = technologyService;
	}
	

	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return technologyService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		technologyService.add(createTechnologyRequest);
		
	}
	
//	@GetMapping("/getById")
//	public ProgrammingLanguage getById(int id) {
//		return programmingLanguageService.getById(id);
//	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest, String technologyName) {
		technologyService.update(updateTechnologyRequest, technologyName);
	}
}

package kodlama.io.programmingLanguage.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguage.business.abstracts.TechnologyService;
import kodlama.io.programmingLanguage.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.programmingLanguage.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyListResponse;
import kodlama.io.programmingLanguage.business.responses.technology.TechnologyResponse;
import kodlama.io.programmingLanguage.business.responses.technology.UpdateTechnologyResponse;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

	
	private TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public TechnologyResponse add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
		
		return this.technologyService.add(createTechnologyRequest);	
		
	}
	
	@GetMapping("/getall")
	public List<TechnologyListResponse> getAll(){
		return this.technologyService.getAll();
	}
	
	
	@DeleteMapping("/delete")
	public TechnologyDeleteResponse delete(@RequestParam int id) {
		return this.technologyService.delete(id);
	}
	
	@PutMapping("/update")
	public UpdateTechnologyResponse update(@RequestParam int id, @RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		return this.technologyService.update(id, updateTechnologyRequest);
	}
	
	@GetMapping("/getById")
	public TechnologyResponse getById(@RequestParam int id) {
		return this.technologyService.getById(id);
	}
	
	
	
	
	
	
	
	
}

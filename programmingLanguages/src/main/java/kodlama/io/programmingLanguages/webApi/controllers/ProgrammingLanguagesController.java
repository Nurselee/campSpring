package kodlama.io.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programmingLanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllProgrammingLanguagesResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		
		this.programmingLanguageService = programmingLanguageService;
	}
	

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.add(createProgrammingLanguageRequest);
		
	}
	
//	@GetMapping("/getById")
//	public ProgrammingLanguage getById(int id) {
//		return programmingLanguageService.getById(id);
//	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateprogrammingLanguagerequest, String name) {
		programmingLanguageService.update(updateprogrammingLanguagerequest, name);
	}
	
	
	
}

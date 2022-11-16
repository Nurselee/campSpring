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

import kodlama.io.programmingLanguage.business.abstracts.LanguageService;
import kodlama.io.programmingLanguage.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguage.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguage.business.responses.language.LanguageDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageListResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageResponse;
import kodlama.io.programmingLanguage.business.responses.language.UpdateLanguageResponse;
import kodlama.io.programmingLanguage.entities.concretes.Language;

@RestController
@RequestMapping("/language")
public class LanguageController {
	
	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public LanguageResponse add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		
		return this.languageService.add(createLanguageRequest);	
		
	}
	
	@GetMapping("/getall")
	public List<LanguageListResponse> getAll(){
		return this.languageService.getAll();
	}
	
	@DeleteMapping("/delete")
	public LanguageDeleteResponse delete(@RequestParam int id) {
		return this.languageService.delete(id);
	}
	
	@PutMapping("/update")
	public UpdateLanguageResponse update(@RequestParam int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) {
		return this.languageService.update(id, updateLanguageRequest);
	}
	
	@GetMapping("/getById")
	public LanguageResponse getById(@RequestParam int id) {
		return this.languageService.getById(id);
	}

}

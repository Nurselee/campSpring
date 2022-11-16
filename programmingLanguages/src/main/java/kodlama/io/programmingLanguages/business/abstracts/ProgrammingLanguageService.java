package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.GetAllProgrammingLanguagesResponse;


public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	//ProgrammingLanguage getById(int id);
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, String name);
}

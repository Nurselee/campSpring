package kodlama.io.programmingLanguage.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguage.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguage.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguage.business.responses.language.LanguageDeleteResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageListResponse;
import kodlama.io.programmingLanguage.business.responses.language.LanguageResponse;
import kodlama.io.programmingLanguage.business.responses.language.UpdateLanguageResponse;

public interface LanguageService {
	
	LanguageResponse add(CreateLanguageRequest createLanguageRequest);
	List<LanguageListResponse> getAll();
	LanguageDeleteResponse delete(int id);
	UpdateLanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest);
	LanguageResponse getById(int id);

}

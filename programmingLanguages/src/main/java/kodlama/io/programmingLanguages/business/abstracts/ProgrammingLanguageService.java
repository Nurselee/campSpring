package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	void delete(int id);
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	ProgrammingLanguage getById(int id);
	void update(ProgrammingLanguage programmingLanguage);
}

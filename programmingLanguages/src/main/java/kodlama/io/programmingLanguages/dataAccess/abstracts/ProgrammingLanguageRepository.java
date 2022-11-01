package kodlama.io.programmingLanguages.dataAccess.abstracts;

import java.util.List;



import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;


public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();
	void delete(int id);
	void add(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);
	void update(ProgrammingLanguage programmingLanguage);
}

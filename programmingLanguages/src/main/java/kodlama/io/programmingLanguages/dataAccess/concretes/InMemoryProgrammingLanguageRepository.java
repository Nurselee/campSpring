package kodlama.io.programmingLanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;


@Repository //this class is an object of the dataAccess
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Python"));
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguages;
	}


	@Override
	public void delete(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId() == id) {
				programmingLanguages.remove(programmingLanguage);
			}
			else {
				System.out.println("No id matched");
			}
		} 
		
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		
		programmingLanguages.add(programmingLanguage);
		
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		} return null;
	}


	@Override
	public void update(ProgrammingLanguage _programmingLanguage) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == _programmingLanguage.getId()) {
            	programmingLanguage.setName(_programmingLanguage.getName());
            }
        }
	}

}

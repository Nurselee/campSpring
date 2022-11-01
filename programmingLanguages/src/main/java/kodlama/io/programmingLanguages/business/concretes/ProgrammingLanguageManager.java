package kodlama.io.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programminLanguageRepository) {
		
		this.programmingLanguageRepository = programminLanguageRepository;
	}



	@Override
	public List<ProgrammingLanguage> getAll() {
		// business rules
		return programmingLanguageRepository.getAll();
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		programmingLanguageRepository.delete(id);
	}
	



	@Override
	public void add(ProgrammingLanguage _programmingLanguage) {
		for (ProgrammingLanguage programmingLanguage:programmingLanguageRepository.getAll()) {
			if(programmingLanguage.getName() == _programmingLanguage.getName() || _programmingLanguage.getName().isEmpty()) {
				
				System.out.println("programming Language cannot be added");
				return;
			}
			
		}
		programmingLanguageRepository.add(_programmingLanguage);
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return programmingLanguageRepository.getById(id);
	}



	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(programmingLanguage);
	}

}


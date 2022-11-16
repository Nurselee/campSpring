package kodlama.io.programmingLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.programmingLanguage.entities.concretes.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer>{

	boolean existsByNameContainingIgnoreCase(String name);
	boolean existsById(int id);
}

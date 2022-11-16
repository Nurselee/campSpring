package kodlama.io.programmingLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.programmingLanguage.entities.concretes.Technology;


@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}

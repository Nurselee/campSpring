package kodlama.io.programmingLanguages.business.responses;


import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {

	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}

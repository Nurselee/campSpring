package kodlama.io.programmingLanguages.business.responses;

import java.util.List;

import kodlama.io.programmingLanguages.entities.concretes.Technologies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
	
	private int id;
	private String name;
	private List<Technologies> technologies;
}

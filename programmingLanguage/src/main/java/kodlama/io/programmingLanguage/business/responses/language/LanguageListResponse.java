package kodlama.io.programmingLanguage.business.responses.language;

import java.util.List;

import kodlama.io.programmingLanguage.business.responses.technology.TechnologyListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageListResponse {
	
	private int id;
	private String name;

	private List<TechnologyListResponse> technologies;
}

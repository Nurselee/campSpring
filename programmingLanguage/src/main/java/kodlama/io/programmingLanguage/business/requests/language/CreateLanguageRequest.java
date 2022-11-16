package kodlama.io.programmingLanguage.business.requests.language;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {

	private String name;
	
	private List<Integer> technologyIds;
}

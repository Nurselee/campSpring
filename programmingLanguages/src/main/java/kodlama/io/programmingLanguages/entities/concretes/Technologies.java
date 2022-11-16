package kodlama.io.programmingLanguages.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technologies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technologyId")
	private int id;
	
	@Column(name = "technologyName")
	private String name;
	

}

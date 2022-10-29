package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import kodlama.io.rentACar.business.abstratcs.BrandService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir.
public class BrandsManager implements BrandService{

	private BrandRepository brandRepository;
	
	@Autowired
	public BrandsManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}


	
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandRepository.getAll();
	}

}

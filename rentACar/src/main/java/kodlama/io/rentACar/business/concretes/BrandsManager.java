package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.rentACar.business.abstratcs.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
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


	
	public List<GetAllBrandsResponse> getAll() {
		// TODO Auto-generated method stub
		
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
		for(Brand brand:brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			
			brandsResponse.add(responseItem);
		}
		return brandsResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
		
	}

}

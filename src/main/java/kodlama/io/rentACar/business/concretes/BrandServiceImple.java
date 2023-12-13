package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBranRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service//Bu sinif bir business nesnesidir demek.
@AllArgsConstructor
public class BrandServiceImple implements BrandService {
private BrandRepository brandRepository;
private ModelMapperService modelMapperService;
private BrandBusinessRules brandBusinessRules;



    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands=brandRepository.findAll();
        /*
        List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();

        for (Brand brand:brands
             ) {GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);

        }

         */


        List<GetAllBrandsResponse> brandsResponse=brands.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());//koleksiyonlari tek tek dolasiyor ve her bir brand icin bir mapleme (modelmapperservice yi kullanarak) yap ve donusum gerceklestir.En sonda ise bunlari topla ve su tipe cvir dedik(Collectors.toList())
        return brandsResponse;
    }



    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        //Brand brand=new Brand();
        //brand.setName(createBrandRequest.getName());

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());//birden fazla isim kuralini kontrol eder
        //kisaca burasi tum int brand vs. vs. degiskenlerini set ediyor gibi dusun (brand.setName(createBrandRequest.getName())) islemini yapiyor gibi dusun.
        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }
    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand= this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }
    @Override
    public void update(UpdateBranRequest updateBranRequest) {

        Brand brand=this.modelMapperService.forRequest().map(updateBranRequest,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }
}

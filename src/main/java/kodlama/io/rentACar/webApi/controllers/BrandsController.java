package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBranRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController//annotation
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;


    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);

    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    //putmapping guncelleme icin kullanilir
    @PutMapping
    public void update(@RequestBody UpdateBranRequest updateBranRequest){
        this.brandService.update(updateBranRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}

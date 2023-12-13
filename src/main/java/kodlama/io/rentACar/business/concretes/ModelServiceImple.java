package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllMobelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImple implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllMobelsResponse> getAll() {
        List<Model> models=modelRepository.findAll();

        List<GetAllMobelsResponse> modelsResponse=models.stream()
                .map(model ->this.modelMapperService.forResponse()
                        .map(model, GetAllMobelsResponse.class)).collect(Collectors.toList());//koleksiyonlari tek tek dolasiyor ve her bir brand icin bir mapleme (modelmapperservice yi kullanarak) yap ve donusum gerceklestir.En sonda ise bunlari topla ve su tipe cvir dedik(Collectors.toList())


        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
         Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
         this.modelRepository.save(model);
    }
}

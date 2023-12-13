package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.request.UpdateBranRequest;
import kodlama.io.rentACar.business.responses.GetAllMobelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface ModelService {

    List<GetAllMobelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}

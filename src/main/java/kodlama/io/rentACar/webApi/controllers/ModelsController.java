package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllMobelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController//annotation
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllMobelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}

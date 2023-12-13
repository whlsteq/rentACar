package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperServiceImple implements ModelMapperService{
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        //gevsek mappleme yap ....> id name brand vs response edildiginde birisi bile olmazsa sorun cikartma
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        //standar mappleme yap ....> id name brand vs response edildiginde birisi bile olmazsa sorun cikart!
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;

    }
}

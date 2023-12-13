package kodlama.io.rentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails{
    private Map<String ,String> validationErrors;

}

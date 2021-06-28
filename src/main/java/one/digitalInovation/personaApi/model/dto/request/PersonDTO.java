package one.digitalInovation.personaApi.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long cd_Person;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nm_FirstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nm_LastName;


    @NotEmpty
    @CPF
    private String cd_Cpf;

    private String dt_BirthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;


}





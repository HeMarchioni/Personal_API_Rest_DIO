package one.digitalInovation.personaApi.model.person;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long cd_Person;
    private String nm_FirstName,nm_LastName,cd_Cpf;
    private LocalDate dt_BirthDate;
    private List<Phone> cd_Phones;

}

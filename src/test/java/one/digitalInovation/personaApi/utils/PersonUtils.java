package one.digitalInovation.personaApi.utils;


import one.digitalInovation.personaApi.model.dto.request.PersonDTO;
import one.digitalInovation.personaApi.model.entity.person.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .nm_FirstName(FIRST_NAME)
                .nm_LastName(LAST_NAME)
                .cd_Cpf(CPF_NUMBER)
                .dt_BirthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .cd_Person(PERSON_ID)
                .nm_FirstName(FIRST_NAME)
                .nm_LastName(LAST_NAME)
                .cd_Cpf(CPF_NUMBER)
                .dt_BirthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}

package one.digitalInovation.personaApi.service;


import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.dto.request.PersonDTO;
import one.digitalInovation.personaApi.model.person.Person;
import one.digitalInovation.personaApi.model.person.PersonRepository;
import one.digitalInovation.personaApi.model.person.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalInovation.personaApi.utils.PersonUtils.createFakeDTO;
import static one.digitalInovation.personaApi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock // -> insatacia fake com moki
    private PersonRepository personRepository;

    @InjectMocks  // -> metodo que ira ser testado
    private PersonService personService;


    @Test
    void testGivenPersonDTOTheReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectadeMessageResponse(expectedSavedPerson.getCd_Person());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);

    }

    private MessageResponseDTO createExpectadeMessageResponse(Long cd_person) {
        return  MessageResponseDTO.builder()
                .message("Created person with ID"+ cd_person)
                .build();
    }
}

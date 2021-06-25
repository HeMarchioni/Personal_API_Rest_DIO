package one.digitalInovation.personaApi.contoller;


import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.person.Person;
import one.digitalInovation.personaApi.model.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    private ApplicationContext context;


    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder() // -> abrindo um construtor
                .message("Created person with ID"+ savedPerson.getCd_Person()) // -> Preenchendo a Variável que tem na Classe
                .build();


    }




}

package one.digitalInovation.personaApi.contoller;


import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.person.Person;
import one.digitalInovation.personaApi.model.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)   // -> padronizar a resposta caso sucesso 201 falha 404
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }




}

package one.digitalInovation.personaApi.contoller;


import one.digitalInovation.personaApi.exception.PersonNotFoundException;
import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.dto.request.PersonDTO;
import one.digitalInovation.personaApi.model.person.Person;
import one.digitalInovation.personaApi.model.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)   // -> padronizar a resposta caso sucesso 201 falha 404
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) { //@Valid chama a validação criada na classe
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
       return personService.listAll();
    }

    @GetMapping("/{cd_Person}")
    public PersonDTO findById(@PathVariable Long cd_Person) throws PersonNotFoundException {
        return personService.findById(cd_Person);

    }

}

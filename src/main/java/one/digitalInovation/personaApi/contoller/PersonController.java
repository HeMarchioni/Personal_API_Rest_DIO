package one.digitalInovation.personaApi.contoller;


import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))  // -> inicializa os construtores das dependências que ira usar (lombok)
public class PersonController {

    private final PersonService personService;

   /* @Autowired    -> antes iniciava 1 a 1.
    public PersonController(PersonService personService) {
        this.personService = personService;
    }*/


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

    @PutMapping("/{cd_Person}")
    public MessageResponseDTO updateById(@PathVariable Long cd_Person,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
       return personService.updateById(cd_Person, personDTO);
    }


    @DeleteMapping("/{cd_Person}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long cd_Person) throws PersonNotFoundException {
        personService.delete(cd_Person);
    }


}

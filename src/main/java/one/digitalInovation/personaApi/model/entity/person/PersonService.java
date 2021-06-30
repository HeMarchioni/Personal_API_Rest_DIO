package one.digitalInovation.personaApi.model.entity.person;


import lombok.AllArgsConstructor;
import one.digitalInovation.personaApi.exception.PersonNotFoundException;
import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.dto.request.PersonDTO;
import one.digitalInovation.personaApi.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))  // -> inicializa os construtores das dependências atributos que ira usar (lombok)
public class PersonService {


    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


   /* @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }*/


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getCd_Person(), "Created person with ID"); // -> mensagem enviada Sucesso
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople =personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long cd_person) throws PersonNotFoundException {
       var person = verifyIfExists(cd_person);

       return personMapper.toDTO(person);
    }


    public void delete(Long cd_person) throws PersonNotFoundException {
        var person = verifyIfExists(cd_person);

        personRepository.deleteById(cd_person);

    }



    public MessageResponseDTO updateById(Long cd_person, PersonDTO personDTO) throws PersonNotFoundException {
       verifyIfExists(cd_person);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatePerson.getCd_Person() , "Update person with ID"); // -> mensagem Sucesso
    }




    private Person verifyIfExists(Long cd_person) throws PersonNotFoundException {  // -> method que verifica se a no banco esse person se tiver retorna o person se nao retorna uma excessão
        return personRepository.findById(cd_person)
                .orElseThrow(()-> new PersonNotFoundException(cd_person) );
    }


    private MessageResponseDTO createMessageResponse(Long cd_Person ,  String message) {
        return MessageResponseDTO
                .builder() // -> abrindo um construtor
                .message(message + cd_Person) // -> Preenchendo a Variável que tem na Classe
                .build();
    }
}

package one.digitalInovation.personaApi.model.person;


import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder() // -> abrindo um construtor
                .message("Created person with ID"+ savedPerson.getCd_Person()) // -> Preenchendo a Variável que tem na Classe
                .build();
    }



}

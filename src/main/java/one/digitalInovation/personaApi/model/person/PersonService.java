package one.digitalInovation.personaApi.model.person;


import one.digitalInovation.personaApi.model.dto.MessageResponseDTO;
import one.digitalInovation.personaApi.model.dto.request.PersonDTO;
import one.digitalInovation.personaApi.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder() // -> abrindo um construtor
                .message("Created person with ID"+ savedPerson.getCd_Person()) // -> Preenchendo a Variável que tem na Classe
                .build(); // -> fecha
    }



}

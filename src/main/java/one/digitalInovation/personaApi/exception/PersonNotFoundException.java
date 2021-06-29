package one.digitalInovation.personaApi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long cd_person) {
        super("Person not found witch ID"+ cd_person);
    }
}

package fi.studio.c63.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException() {
        super("Invalid credential!");
    }
}

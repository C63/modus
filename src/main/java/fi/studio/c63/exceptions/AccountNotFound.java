package fi.studio.c63.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFound extends RuntimeException {
    public AccountNotFound(Long id) {
        super(String.format("Account with this id: %d is not exist", id));
    }
}

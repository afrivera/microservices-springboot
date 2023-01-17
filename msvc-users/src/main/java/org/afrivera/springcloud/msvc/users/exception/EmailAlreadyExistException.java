package org.afrivera.springcloud.msvc.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmailAlreadyExistException extends RuntimeException{

    private String emailField;

    public EmailAlreadyExistException(String emailField) {
        super(String.format("%s already on use", emailField));
        this.emailField = emailField;
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }
}

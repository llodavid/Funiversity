package be.llodavid.api;

import be.llodavid.service.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackages = {"be.llodavid"})
public class GlobalAdviceController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> returnStatusForUnknownIdException(final ResourceNotFoundException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }
}

package peaksoft.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalHandlerException {

    //not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse notFound(NotFoundException e) {
        log.error(e.getMessage());
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BadCredentialsException.class)
    public ExceptionResponse badCredentials(BadCredentialsException e) {
        log.error(e.getMessage());
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponse badRequest(BadRequestException e) {
        log.error(e.getMessage());
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponse alreadyExists(AlreadyExistsException e) {
        log.error(e.getMessage());
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .build();
    }
}

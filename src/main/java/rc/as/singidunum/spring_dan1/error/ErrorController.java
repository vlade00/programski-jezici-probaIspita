package rc.as.singidunum.spring_dan1.error;

//Ova klasa sluzi za greske 404 itd

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component

public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage("Data integrity was breached");
        model.setPath(request.getServletPath());
        return model;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handlerException(Exception e, HttpServletRequest request){
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage(e.getMessage());
        model.setPath(request.getServletPath());
        return model;
    }
}

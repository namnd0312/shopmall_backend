package nam.nd.shopmall.exception;

import nam.nd.shopmall.enums.MessageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author nam.nd
 * @created 17/06/2021 - 11:06 PM
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     Handle exception for validate input data field and custom validation;
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getField() + " " + e.getDefaultMessage()));

        String description = String.join("#", new ArrayList<>(errors.values()));

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode("401");
        errorDetails.setMessage(description);
        errorDetails.setTimestamp(new Date());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LogicException.class)
    public ResponseEntity<?> logicException(LogicException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(ex.getCode() == null ? ex.getMessageEnum().getCode() : ex.getCode());
        errorDetails.setMessage(  ex.getMessage() == null ? ex.getMessageEnum().getMessage() :  ex.getMessage());
        errorDetails.setTimestamp(new Date());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex) {
        if(ex instanceof LogicException) {
            MessageEnum messageEnum = ((LogicException) ex).getMessageEnum();
            switch (messageEnum){
                case RECORD_NOT_EXIST:
                    return new ResponseEntity<>(getErrorDetails(messageEnum), HttpStatus.NOT_FOUND);
//                case RECORD_EXISTED:
//                case COMPANY_NAME_EXISTED:
//                case LOCATION_CODE_EXISTED:
//                case JOB_APPLIED:
//                case LOCATION_NAME_EXISTED:
//                    return new ResponseEntity<>(getErrorDetails(messageEnum), HttpStatus.CONFLICT);

                case BAD_REQUEST:
                    return new ResponseEntity<>(getErrorDetails(messageEnum), HttpStatus.BAD_REQUEST);
                default:
                    return new ResponseEntity<>(getErrorDetails(messageEnum), HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(getErrorDetails(MessageEnum.INTERNAL_API_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private ErrorDetails getErrorDetails(MessageEnum messageEnum){
        return new ErrorDetails(new Date(), messageEnum.getCode(), messageEnum.getMessage());
    }
}

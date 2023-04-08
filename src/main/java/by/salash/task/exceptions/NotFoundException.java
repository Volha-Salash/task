package by.salash.task.exceptions;

/**
 * @author : Volha Salash
 */

/**
 * class of exception thrown when not able to find a user
 */
public class NotFoundException extends AppException {

    public NotFoundException(String message) {
        super(message);
    }

}
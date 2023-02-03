package command_errors;

public class InvalidFirstArgumentException extends CommandException {

    public InvalidFirstArgumentException(String message) {
        super(message);
    }
}

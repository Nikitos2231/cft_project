package command_errors;

public class CommandException extends RuntimeException {

    public CommandException(String message) {
        super(message);
    }
}

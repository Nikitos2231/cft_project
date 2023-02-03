package command_errors;

public class InvalidAmountCommandException extends CommandException {

    public InvalidAmountCommandException(String message) {
        super(message);
    }
}

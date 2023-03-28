package exceptions;

public class CommandExecutionException extends Exception {
    public CommandExecutionException(Exception exception) {
        super("There are some issues when trying to execute command!" + exception);
    }
}

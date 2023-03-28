package utils.command;

import exceptions.CommandExecutionException;


public interface Command {
    void execute() throws CommandExecutionException;
}

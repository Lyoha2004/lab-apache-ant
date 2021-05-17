package commands;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Команда для вывода всех возможных команд
 */
public class Help extends Command {
    CommandManager commandManager;
    public Help(CommandManager commandManager) {
        this.name = "help";
        this.description = ResourceBundle.getBundle("res.Descriptions").getString("help");
        this.commandManager = commandManager;
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();
        result.append(ResourceBundle.getBundle("res.Descriptions").getString("help_preview"));
        result.append(":\n");
        for (Command cmd : commandManager.getCommands().values()) {
            String name = cmd.getName();
            String description = cmd.getDescription();
            String arguments = cmd.getArguments();
            result.append(String.format("\t%-40s%-150s\n", name + " " + arguments, description));
        }
        return result.toString();
    }

    @Override
    public void readParameters(Scanner sc) { }
}

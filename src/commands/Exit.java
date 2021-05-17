package commands;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Команды для выхода из программы
  */
public class Exit extends Command {

    public Exit() {
        this.name = "exit";
        this.description = ResourceBundle.getBundle("res.Descriptions").getString("exit");
    }

    /**
     * Завершает программу
     * @return
     */
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}

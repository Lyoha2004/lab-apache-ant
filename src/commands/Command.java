package commands;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Абстрактный класс представления команды
 */
public abstract class Command {
    protected String name;
    protected String description;
    protected String arguments = "";

    /**
     * Запускает команду
     * @return
     */
    public abstract String execute();

    /**
     * Считывает параметры необходимые команде
     * @param sc
     * @throws IOException
     */
    public void readParameters(Scanner sc) throws IOException {};

    /**
     * Возвращает название команды
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание команды
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает аргументы команды
     * @return
     */
    public String getArguments() {
        return arguments;
    }
}

package client;

import commands.Command;
import commands.CommandManager;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Класс для работы с клиентом (вывод сообщений, чтение команд, определение типа команды и т.п.)
 */
public class Client {
    private static volatile Client instance;
    private Scanner scanner;
    private CommandManager commandManager;
    private PrintStream out;

    private Client(Scanner scanner, PrintStream out, CommandManager commandManager) {
        this.scanner = scanner;
        this.out = out;
        this.commandManager = commandManager;
    }

    public static void init(Scanner scanner, PrintStream out, CommandManager commandManager) {
        instance = new Client(scanner, out, commandManager);
    }


    /**
     * Паттерн Singleton для того, чтобы в одной программе был один клиент.
     * Для работы с ним необходимо сначала проинициализировать объект client.Client.init(...),
     * а затем взять его объект client.Client.getInstance()
     * @return
     * @throws IllegalAccessException
     */
    public synchronized static Client getInstance() throws IllegalAccessException {
        if (instance == null) {
            throw new IllegalAccessException(ResourceBundle.getBundle("res.Messages").getString("client_instance_error"));
        }
        return instance;
    }

    /**
     * Запускает работу с клиентом: ввод, обработка, вывод сообщений
     */
    public void run() {
        String commandName;

        /*
        * Главный цикл программы. За каждый проход по цику происходит считывание одной команды её обработка
        * */
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                continue;
            Scanner scanLine = new Scanner(line);
            commandName = scanLine.next();
            Command cmd = commandManager.getCommand(commandName);

            // Проверка на то, что команда нашлась и её можно вызвать
            if (cmd == null) {
                out.println(ResourceBundle.getBundle("res.Messages").getString("no_such_command"));
                continue;
            }
            try {
                cmd.readParameters(scanLine);   // Считываем аргументы команды
            } catch (IOException e) {
                out.println(ResourceBundle.getBundle("res.Messages").getString("wrong_arguments"));
                continue;
            }
            String output = cmd.execute();
            out.print(output);
        }
    }
}

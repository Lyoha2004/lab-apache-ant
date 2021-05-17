package client;

import commands.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Главный класс откуда происходит запуск приложения
 */
public class LabApacheAnt {
    static String usage = ResourceBundle.getBundle("res.Messages").getString("usage");
    History history;

    public static void main(String[] args) {
        System.out.println(usage);

        LabApacheAnt lab = new LabApacheAnt();
        lab.run();
    }

    /**
     * Запускает приложение
     */
    private void run() {
        // Необходим один экземпляр для команды Shot и CommandManager, чтобы результаты выстрелов самостоятельно
        // записывались в историю
        history = new History();

        // Менеджер команд. Хранит в себе все команды
        CommandManager commandManager = new CommandManager();
        addCommands(commandManager);

        // Инициализируем объект клиента
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Client.init(scanner, System.out, commandManager);
        Client client = null;
        try {
            client = Client.getInstance();
        } catch (IllegalAccessException initError) {
            initError.printStackTrace();
        }

        assert client != null;
        client.run();
    }

    /**
     * Добавляет все команды, которые будут использованы в приложении
     * @param commandManager
     */
    private void addCommands(CommandManager commandManager) {
        commandManager.addCommand("help", new Help(commandManager));
        commandManager.addCommand("shot", new Shot(history));
        commandManager.addCommand("history", history);
        commandManager.addCommand("exit", new Exit());
    }
}

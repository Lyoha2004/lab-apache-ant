package commands;

import commands.Command;

import java.util.HashMap;

/**
 * Менеджер команд. Сохраняет в себе все возможные команды, чтобы можно
 * было легко их достать и вызвать по названию команды
 */
public class CommandManager {
    /**
     * Здесь хранится соответствие названиеКоманды - команда
     */
    HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Добавляет команду в менеджер
     * @param name
     * @param cmd
     */
    public void addCommand(String name, Command cmd) {
        commandMap.put(name, cmd);
    }

    /**
     * Возвращает команду по её названию
     * @param name
     * @return
     */
    public Command getCommand(String name) {
        return commandMap.get(name);
    }

    /**
     * Возвращает все доступные команды
     * @return
     */
    public HashMap<String, Command> getCommands() {
        return commandMap;
    }
}

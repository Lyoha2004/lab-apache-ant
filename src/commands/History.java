package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Команда для отображения истории выстрелов (последних 10)
 */
public class History extends Command {
    List<String> history;

    public History() {
        this.name = "history";
        this.description = ResourceBundle.getBundle("res.Descriptions").getString("history");
        history = new ArrayList<>();
    }

    public void addShot(String shotResult) {
        history.add(shotResult);
    }

    @Override
    public String execute() {
        if (history.isEmpty())
            return ResourceBundle.getBundle("res.Messages").getString("history_empty");
        StringBuilder sb = new StringBuilder();
        List<String> tail = history.subList(Math.max(history.size() - 9, 0), history.size());
        for (String shotResult : tail)
            sb.append(shotResult).append('\n');
        return sb.toString();
    }

    @Override
    public void readParameters(Scanner sc) { }
}

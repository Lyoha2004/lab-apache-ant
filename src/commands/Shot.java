package commands;

import utilities.ValidateInput;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Команда для совершения выстрела в область
 */
public class Shot extends Command {
    History history;
    double R, X, Y;

    public Shot(History history) {
        this.name = "shot";
        this.description = ResourceBundle.getBundle("res.Descriptions").getString("shot");
        this.arguments = "[R] [X] [Y]";
        this.history = history;
    }

    @Override
    public String execute() {
        boolean hit = false;    // Попал в цель
        // Проверяем попадание во вторую четверть радиуса R
        if (X <= 0 && Y >= 0 && Math.sqrt(X * X + Y * Y) <= R)
            hit = true;
        // Проверяем попадание в треугольник, находящийся в 3-й четверти
        // Для этого необходимо составить уравнение прямой и подставить значение точки.
        // Если значение будет отрицательно, то точка находится в верхней полуплоскости
        if (X <= 0 && Y <= 0 && -R * X - R * Y / 2 - R * R / 2 <= 0)
            hit = true;
        // Проверяем попадание в квадрат, находящийся в четвёртой четверти
        if (X >= 0 && X <= R && Y <= 0 && Y >= -R)
            hit = true;

        String result = ResourceBundle.getBundle("res.Messages").getString("shot") +
                " ( X = " + X + ", Y = " + Y + ", R = " + R + ") " +
                (hit ? ResourceBundle.getBundle("res.Messages").getString("hit_the_target") :
                        ResourceBundle.getBundle("res.Messages").getString("flew_by"));
        history.addShot(result);
        return result + '\n';
    }

    @Override
    public void readParameters(Scanner sc) throws IOException {
        ValidateInput vi = new ValidateInput(sc);
        R = vi.validateDouble();
        X = vi.validateDouble();
        Y = vi.validateDouble();
    }
}

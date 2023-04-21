package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;

public class SQRT extends Command {
    @Override
    public void action(String... strings) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        if (stack.peek() < 0)
            throw new ArithmeticException("Ошибка: корень из отрицательного числа!");

        stack.push(Math.sqrt(stack.pop()));
    }
}

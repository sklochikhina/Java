package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;

public class Division extends Command {
    @Override
    public void action(String... strings) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        else if (stack.size() == 1)
            throw new IOException("Ошибка: стек содержит один элемент - деление невозможно!");

        double peek = stack.pop();
        if (stack.peek() == 0)
            throw new ArithmeticException("Ошибка: деление на ноль невозможно!");

        stack.push(peek / stack.pop());
    }
}

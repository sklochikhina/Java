package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;
import java.util.Stack;

public class SQRT implements Command {
    private final Stack<Double> stack;

    public SQRT(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void action(String... strings) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        if (stack.peek() < 0)
            throw new ArithmeticException("Ошибка: корень из отрицательного числа!");

        stack.push(Math.sqrt(stack.pop()));
    }
}

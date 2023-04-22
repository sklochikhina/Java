package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;
import java.util.Stack;

public class POP implements Command {
    private final Stack<Double> stack;

    public POP(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void action(String... strings) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        stack.pop();
    }
}

package ru.nsu.klochikhina.calculator.model.commands;

import ru.nsu.klochikhina.calculator.model.factory.Command;

import java.io.IOException;
import java.util.Stack;

public class Multiplication extends Command {
    @Override
    public void action(Stack<Double> stack) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        else if (stack.size() == 1)
            throw new IOException("Ошибка: стек содержит один элемент - умножение невозможно!");

        stack.push(stack.pop() * stack.pop());
    }
}

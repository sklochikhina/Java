package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;

public class POP extends Command {
    @Override
    public void action(String... strings) throws Exception {
        if (stack.isEmpty())
            throw new IOException("Ошибка: стек пуст!");
        stack.pop();
    }
}

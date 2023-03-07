package ru.nsu.klochikhina.calculator.model.commands;

import ru.nsu.klochikhina.calculator.model.factory.Command;

import java.io.IOException;

// TODO: реализовать поиск по карте
public class DEFINE extends Command {
    @Override
    public void action(String... strings) throws Exception {
        if (defineList.containsKey(strings[0]))
            throw new IOException("Значение " + strings[0] + " уже определено как " + defineList.get(strings[0]) + ".");
        else
            defineList.put(strings[0], Double.parseDouble(strings[1]));
    }
}

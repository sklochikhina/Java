package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;

public class PUSH extends Command {
    @Override
    public void action(String... strings) throws Exception {
        if (defineList.containsKey(strings[0]))
            stack.push(defineList.get(strings[0]));
        else
            stack.push(Double.parseDouble(strings[0]));
    }
}

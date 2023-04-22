package main.java.ru.nsu.klochikhina.calculator.model.commands;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import java.io.IOException;
import java.util.Map;

public class DEFINE implements Command {
    private final Map<String, Double> defineList;
    public DEFINE(Map<String, Double> defineList){
        this.defineList = defineList;
    }
    @Override
    public void action(String... strings) throws Exception {
        if (defineList.containsKey(strings[0]))
            throw new IOException("Значение " + strings[0] + " уже определено как " + defineList.get(strings[0]) + ".");
        else
            defineList.put(strings[0], Double.parseDouble(strings[1]));
    }
}

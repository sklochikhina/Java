package ru.nsu.klochikhina.calculator.model.commands;

import ru.nsu.klochikhina.calculator.model.factory.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// TODO: реализовать поиск по карте
public class DEFINE extends Command {
    private final static Map<String, Double> DefineList = new HashMap<>();
    @Override
    public void action(Stack<Double> stack) throws Exception {
        /*if (DefineList.containsKey(define))
            throw new IOException("Значение " + define + " уже определено как " + DefineList.get(define) + ".");
        else
            DefineList.put(define, value);*/
    }
}

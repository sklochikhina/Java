package ru.nsu.klochikhina.calculator.model.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class Command {
    protected static Stack<Double> stack = new Stack<>();
    protected static Map<String, Double> defineList = new HashMap<>();
    public abstract void action(String... strings) throws Exception;
}

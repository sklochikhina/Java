package ru.nsu.klochikhina.calculator.model;

import java.io.IOException;
import java.util.*;

public class Commands {
    private final static Map<String, Double> DefineList = new HashMap<>();
    private final static Stack<Double> stack = new Stack<>();
    public static void comment() {
        // ??
    }
    public static Stack<Double> POP() {
        stack.pop();
        return stack;
    }
    public static Stack<Double> PUSH(double num) {
        stack.push(num);
        return stack;
    }
    public static double add() {
        double first = stack.pop(), second = stack.pop();
        double result = first + second;
        stack.push(result);
        return result;
    }
    public static double sub() {
        double first = stack.pop(), second = stack.pop();
        double result = first - second;
        stack.push(result);
        return result;
    }
    public static double mul() {
        double first = stack.pop(), second = stack.pop();
        double result = first * second;
        stack.push(result);
        return result;
    }
    public static double div() {
        double first = stack.pop(), second = stack.pop();
        double result = first / second;
        stack.push(result);
        return result;
    }
    public static Stack<Double> SQRT() {
        stack.push(Math.sqrt(stack.pop()));
        return stack;
    }
    public static void PRINT() {
        System.out.println("Вершина стека: " + stack.peek() + ".");
    }
    public static void DEFINE(String define, double value) throws Exception {
        if (DefineList.containsKey(define))
            throw new IOException("Значение " + define + " уже определено как " + DefineList.get(define) + ".");
        else
            DefineList.put(define, value);
    }
}

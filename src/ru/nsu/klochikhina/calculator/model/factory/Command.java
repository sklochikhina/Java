package ru.nsu.klochikhina.calculator.model.factory;

import java.util.Stack;

public abstract class Command {
    // общие методы для всех наследников
    // абстрактные поля
    public abstract void action(Stack<Double> stack) throws Exception;
}

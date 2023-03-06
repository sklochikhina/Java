package ru.nsu.klochikhina.calculator.model.factory;

import ru.nsu.klochikhina.calculator.model.commands.*;

public class Factory {
    public Command createCommand(Action action) {
        if (action == Action.POP)
            return new POP();
        else if (action == Action.PUSH)
            return new PUSH();
        else if (action == Action.ADDITION)
            return new Addition();
        else if (action == Action.SUBTRACTION)
            return new Subtraction();
        else if (action == Action.MULTIPLICATION)
            return new Multiplication();
        else if (action == Action.DIVISION)
            return new Division();
        else if (action == Action.SQRT)
            return new SQRT();
        else if (action == Action.PRINT)
            return new PRINT();
        else
            return new DEFINE();
    }
}

package ru.nsu.klochikhina.calculator.model.factory;

import java.lang.Class;

public class Factory {
    public Object createCommand(Action action) throws Exception{
        try {
            if (action == Action.POP)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.POP").newInstance();
            else if (action == Action.PUSH)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.PUSH").newInstance();
            else if (action == Action.ADDITION)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.Addition").newInstance();
            else if (action == Action.SUBTRACTION)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.Subtraction").newInstance();
            else if (action == Action.MULTIPLICATION)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.Multiplication").newInstance();
            else if (action == Action.DIVISION)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.Division").newInstance();
            else if (action == Action.SQRT)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.SQRT").newInstance();
            else if (action == Action.PRINT)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.PRINT").newInstance();
            else if (action == Action.COMMENT)
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.Comment").newInstance();
            else
                return Class.forName("ru.nsu.klochikhina.calculator.model.commands.DEFINE").newInstance();
        } catch (ClassNotFoundException e){
            System.out.println("Класс команды не найден.");
        } catch (InstantiationException e){
            System.out.println("Ошибка инициализации.");
        } catch (IllegalAccessException e){
            System.out.println("Ошибка доступа.");
        }
        return null;
    }
}

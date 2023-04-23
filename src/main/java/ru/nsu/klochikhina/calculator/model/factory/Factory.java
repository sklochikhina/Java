package main.java.ru.nsu.klochikhina.calculator.model.factory;

import java.io.IOException;
import java.lang.Class;
import java.util.*;

public class Factory {
    private final static ArrayList<String> noParameterCommands =
            new ArrayList<>(Arrays.asList("POP", "+", "-", "*", "/", "SQRT", "PRINT"));
    private final static ArrayList<String> aFewParametersCommands =
            new ArrayList<>(Arrays.asList("PUSH", "DEFINE"));

    public Command createCommand(String[] action, Stack<Double> stack, Map<String, Double> defineList) throws Exception{
        if (!checkInput(action))
            throw new IOException("Неверный ввод команды или излишнее/недостаточное количество параметров.");

        try {
            if (action[0].equals("POP"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.POP").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("PUSH"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.PUSH").
                        getDeclaredConstructor(Stack.class, Map.class).newInstance(stack, defineList);
            else if (action[0].equals("+"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.Addition").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("-"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.Subtraction").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("*"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.Multiplication").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("/"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.Division").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("SQRT"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.SQRT").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].equals("PRINT"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.PRINT").
                        getDeclaredConstructor(Stack.class).newInstance(stack);
            else if (action[0].startsWith("#"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.Comment").
                        getDeclaredConstructor().newInstance();
            else if (action[0].equals("DEFINE"))
                return (Command) Class.forName("main.java.ru.nsu.klochikhina.calculator.model.commands.DEFINE").
                        getDeclaredConstructor(Map.class).newInstance(defineList);
        } catch (ClassNotFoundException e){
            System.err.println("Класс команды не найден.");
        } catch (InstantiationException e){
            System.err.println("Ошибка инициализации.");
        } catch (IllegalAccessException e){
            System.err.println("Ошибка доступа.");
        }
        return null;
    }

    public boolean checkInput(String[] arr) {
        if(noParameterCommands.contains(arr[0]) && arr.length > 1)
            return false;
        else if (aFewParametersCommands.contains(arr[0]))
            return (!arr[0].equals("PUSH") || arr.length == 2) && (!arr[0].equals("DEFINE") || arr.length == 3);
        else return noParameterCommands.contains(arr[0]) || aFewParametersCommands.contains(arr[0]);
    }

    public static String getCommandList(){
        return "Здравствуйте, я стековый калькулятор! Мои возможности:\n" +
                "# - начало комментария;\n" +
                "POP - снять число со стека;\n" +
                "PUSH - положить чсило на стек;\n" +
                "+, -, *, /, SQRT - доступные арифметические операции с элементами стека;\n" +
                "PRINT - печать верхнего элемента стека;\n" +
                "DEFINE - задать значение параметра;\n" +
                "STOP - останавливает действие программы.\n";
    }
}

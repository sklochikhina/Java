package ru.nsu.klochikhina.calculator.ui;

import ru.nsu.klochikhina.calculator.model.commands.*;
import ru.nsu.klochikhina.calculator.model.factory.Action;
import ru.nsu.klochikhina.calculator.model.factory.Command;
import ru.nsu.klochikhina.calculator.model.factory.Factory;

import java.io.IOException;
import java.util.*;

public class Parsing {
    private final static ArrayList<String> commands =
            new ArrayList<>(Arrays.asList("#", "POP", "PUSH", "+", "-", "*", "/", "SQRT", "PRINT", "DEFINE"));

    public static void parsing() throws Exception {
        Scanner scanner;

        // TODO: System.out.println("Имя файла: ");

        scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine(); // без имени файла
            while(scanner.hasNextLine()) {
                lineCheck(input);
                input = scanner.nextLine();
            }
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }

    public static void lineCheck(String input) throws Exception {
        if (input.isEmpty())
            throw new IOException("Строка пуста!");

        String[] arr = input.split(" ");

        if (arr[0].isEmpty())
            throw new IOException("Неверный ввод");
        else if (!commands.contains(arr[0]) && !arr[0].startsWith("#"))
            throw new IOException("Команда " + input + " не найдена.");
        else if (arr.length > 3 && !arr[0].startsWith("#"))
            throw new IOException("Команда введена неверно: передано слишком много значений.");

        Factory factory = new Factory();

        Action action = chooseAction(arr);


        /*try {
            Double.parseDouble(strings[0]);
        } catch (NumberFormatException e){
            System.out.println(e.getMassage());
        }*/

    }

    public static Action chooseAction(String[] arr){
        switch (arr[0]) {
            case "PUSH":
                return Action.PUSH;
            case "POP":
                return Action.POP;
            case "+":
                return Action.ADDITION;
            case "/":
                return Action.DIVISION;
            case "*":
                return Action.MULTIPLICATION;
            case "-":
                return Action.SUBTRACTION;
            case "#":
                return Action.COMMENT;
            case "DEFINE":
                return Action.DEFINE;
            case "SQRT":
                return Action.SQRT;
            default:
                return Action.PRINT;
        }
    }
}

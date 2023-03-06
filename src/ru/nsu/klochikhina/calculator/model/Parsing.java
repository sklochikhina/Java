package ru.nsu.klochikhina.calculator.model;

import java.io.IOException;
import java.util.*;

public class Parsing {
    private final static ArrayList<String> commands =
            new ArrayList<>(Arrays.asList("#", "POP", "PUSH", "+", "-", "*", "/", "SQRT", "PRINT", "DEFINE"));
    public static void parsing() throws Exception {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Имя файла: ");
        String input = scanner.nextLine(); // без имени файла

        try {
            LineCheck(input);
        } catch (IOException exc){
            System.out.println("Поймана ошибка: неверный ввод " + exc);
        } finally {
            scanner.close();
        }
    }

    public static void LineCheck(String input) throws Exception {
        String[] arr = input.split(" ");

        if (arr.length == 1 && !commands.contains(input))
            throw new IOException("Команда " + input + " не найдена.");
        else if (arr.length > 1 && !commands.contains(arr[0]))
            throw new IOException("Команда " + arr[0] + " не найдена.");
        else if (arr.length > 3)
            throw new IOException("Команда введена неверно: передано слишком много значений.");

        switch (arr[0]) {
            case "#" : Commands.comment(); break;
            case "POP" : Commands.POP(); break;
            case "PUSH" :   if (arr.length > 2)
                                throw new IOException("Команда \"PUSH\" требует одно значение.");
                            Commands.PUSH(Double.parseDouble(arr[1])); break;
            case "+" : Commands.add(); break;
            case "-" : Commands.sub(); break;
            case "*" : Commands.mul(); break;
            case "/" : Commands.div(); break;
            case "SQRT" : Commands.SQRT(); break;
            case "PRINT" : Commands.PRINT(); break;
            case "DEFINE" : if (arr.length < 3)
                                throw new IOException("Команда \"DEFINE\" требует два значения.");
                            Commands.DEFINE(arr[1], Double.parseDouble(arr[2])); break;
        }
    }
}

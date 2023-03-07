package ru.nsu.klochikhina.calculator.ui;

import java.io.IOException;
import java.util.*;

public class Parsing {
    private final static ArrayList<String> commands =
            new ArrayList<>(Arrays.asList("#", "POP", "PUSH", "+", "-", "*", "/", "SQRT", "PRINT", "DEFINE"));

    public static void parsing() throws Exception {
        Scanner scanner = new Scanner(System.in);
        // TODO: System.out.println("Имя файла: ");
        String input = scanner.nextLine(); // без имени файла

        while(LineCheck(input))
            input = scanner.nextLine();

        scanner.close();
    }

    public static boolean LineCheck(String input) throws Exception {
        if (input.isEmpty())
            return false;

        String[] arr = input.split(" ");

        if (arr.length == 1 && !commands.contains(input))
            throw new IOException("Команда " + input + " не найдена.");
        else if (arr.length > 1 && !commands.contains(arr[0]))
            throw new IOException("Команда " + arr[0] + " не найдена.");
        else if (arr.length > 3)
            throw new IOException("Команда введена неверно: передано слишком много значений.");

        switch (arr[0]) {
            /*try {
                Double.parseDouble(strings[0]);
            } catch (NumberFormatException exception){
                System.out.println("Значение " + strings[0]);
            }*/
        }

        return true;
    }
}

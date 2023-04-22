package main.java.ru.nsu.klochikhina.calculator.ui;

import java.io.IOException;
import java.util.*;

public class Parsing {
    private static Scanner scanner;

    public Parsing(String fileName) {
        if (fileName == null)
            scanner = new Scanner(System.in);
        else
            scanner = new Scanner(fileName); // пока не работает?
    }

    public String[] parsing() throws Exception {
        try {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim(); // без имени файла
                if (input.isEmpty())
                    throw new IOException("Строка пуста!");
                return input.split("\\s+");
            }
        } catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}

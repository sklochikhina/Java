package ru.nsu.klochikhina.lab1503.task1.controller;

import java.util.Scanner;

public class Controller {
    private final Scanner scanner = new Scanner(System.in);

    public int getUserInput() {
        if (!scanner.hasNextInt()){
            System.out.println("Вы ввели не целое число. Попробуйте ещё раз.");
            scanner.nextLine();
            return 0;
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public void closeScanner(){
        scanner.close();
    }
}
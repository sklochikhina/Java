package ru.nsu.klochikhina.lab1503.task1.view;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void displayQuestion(int firstNumber, int secondNumber) {
        System.out.printf(firstNumber + " + " + secondNumber + " = ");
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public void displayResult(boolean isCorrect) {
        if (isCorrect)
            System.out.println("Верно!");
        else
            System.out.println("Неверно!");
    }
}

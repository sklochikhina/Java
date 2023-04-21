package main.java.ru.nsu.klochikhina.lab1503.task1.controller;

import main.java.ru.nsu.klochikhina.lab1503.task1.model.Model;
import main.java.ru.nsu.klochikhina.lab1503.task1.view.View;

import java.util.Scanner;

public class Controller {
    private final Scanner scanner;
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.scanner = new Scanner(System.in);
        this.view = view;
    }

    public int getUserInput() {
        if (!scanner.hasNextInt()){
            view.noNumber();
            scanner.nextLine();
            return 0;
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    public void playGame() {
        while (true) {
            model.generateNumbers();
            int input = 0;

            while (input == 0) {
                view.displayQuestion();
                input = getUserInput();
            }

            while (!model.checkAnswer(input)){
                view.displayQuestion();
                input = getUserInput();
                if (input == -1) {
                    closeScanner();
                    view.interrupt();
                    return;
                }
            }
        }
    }

    public void closeScanner(){
        scanner.close();
    }
}
package ru.nsu.klochikhina.lab1503.task1.controller;

import ru.nsu.klochikhina.lab1503.task1.model.Model;
import ru.nsu.klochikhina.lab1503.task1.view.View;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        while (true) {
            model.generateNumbers();

            int firstNumber = model.getFirstNumber();
            int secondNumber = model.getSecondNumber();

            view.displayQuestion(firstNumber, secondNumber);

            int input = view.getUserInput();
            if (input == -1)
                break;

            boolean isCorrect = (input == firstNumber + secondNumber);
            view.displayResult(isCorrect);
        }
    }
}

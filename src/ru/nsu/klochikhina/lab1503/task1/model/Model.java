package ru.nsu.klochikhina.lab1503.task1.model;

import ru.nsu.klochikhina.lab1503.task1.controller.Controller;
import ru.nsu.klochikhina.lab1503.task1.view.View;

import java.util.Random;

public class Model {
    private int firstNumber;
    private int secondNumber;
    private int condition;
    private final Controller controller = new Controller();
    private final View view = new View();

    public Model() {
        generateNumbers();
    }

    public void generateNumbers() {
        Random rand = new Random();
        firstNumber = rand.nextInt(101);
        secondNumber = rand.nextInt(101);
    }

    public void playGame() {
        while (true) {
            condition = 2;
            generateNumbers();
            int input = 0;

            while (input == 0) {
                view.update(this);
                input = controller.getUserInput();
            }

            if (input == -1) {
                condition = -1;
                controller.closeScanner();
                view.update(this);
                break;
            }
            
            condition = checkAnswer(input) ? 1 : 0;
            view.update(this);
        }
    }

    public boolean checkAnswer(int answer) {
        return answer == (firstNumber + secondNumber);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getCondition() {
        return condition;
    }
}
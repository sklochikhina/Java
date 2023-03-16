package ru.nsu.klochikhina.lab1503.task1.model;

import java.util.Random;

public class Model {
    private int firstNumber;
    private int secondNumber;

    public Model() {
        generateNumbers();
    }

    public void generateNumbers() {
        Random rand = new Random();
        firstNumber = rand.nextInt(101);
        secondNumber = rand.nextInt(101);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }
}

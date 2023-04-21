package main.java.ru.nsu.klochikhina.lab1503.task1.model;

import java.util.Random;

public class Model {
    private int firstNumber;
    private int secondNumber;
    private boolean isAnswerCorrect;
    private Listener listener;

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public void generateNumbers() {
        Random rand = new Random();
        firstNumber = rand.nextInt(101);
        secondNumber = rand.nextInt(101);
    }

    public boolean checkAnswer(int answer) {
        if (answer == 0) {
            return false;
        }
        isAnswerCorrect = answer == (firstNumber + secondNumber);
        listener.checkAnswer();
        return isAnswerCorrect;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public boolean isAnswerCorrect() {
        return isAnswerCorrect;
    }
}
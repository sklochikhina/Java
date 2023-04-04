package ru.nsu.klochikhina.lab1503.task1.view;

import ru.nsu.klochikhina.lab1503.task1.model.Listener;
import ru.nsu.klochikhina.lab1503.task1.model.Model;

public class View implements Listener {
    private final Model model;

    public View(Model model) {
        this.model = model;
        this.model.setListener(this);
    }

    public void noNumber(){
        System.out.println("Вы ввели не целое число. Попробуйте ещё раз.");
    }

    public void interrupt() {
        System.out.println("Игра прервана. Чтобы начать заново, перезагрузите программу.");
    }

    public void rightAnswer() {
        System.out.println("Верно!");
    }

    public void wrongAnswer() {
        System.out.println("Неверно! Попробуйте ещё раз.");
    }

    @Override
    public void checkAnswer() {
        if(model.isAnswerCorrect())
            rightAnswer();
        else
            wrongAnswer();
    }

    @Override
    public void displayQuestion() {
        System.out.printf(model.getFirstNumber() + " + " + model.getSecondNumber() + " = ");
    }
}
package ru.nsu.klochikhina.lab1503.task1.view;

import ru.nsu.klochikhina.lab1503.task1.model.Model;

public class View {
    public void update(Model model){
        switch (model.getCondition()){
            case 2: displayQuestion(model.getFirstNumber(), model.getSecondNumber()); break;
            case -1: interrupt(); break;
            case 1: rightAnswer(); break;
            default: wrongAnswer(); break;
        }
    }

    public void displayQuestion(int firstNumber, int secondNumber) {
        System.out.printf(firstNumber + " + " + secondNumber + " = ");
    }

    public void interrupt() {
        System.out.println("Игра прервана. Чтобы начать заново, перезагрузите программу.");
    }

    public void rightAnswer() {
        System.out.println("Верно!");
    }

    public void wrongAnswer() {
        System.out.println("Неверно!");
    }
}
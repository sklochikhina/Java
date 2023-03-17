package ru.nsu.klochikhina.lab1503.task1.ui;

import ru.nsu.klochikhina.lab1503.task1.controller.Controller;
import ru.nsu.klochikhina.lab1503.task1.model.Model;
import ru.nsu.klochikhina.lab1503.task1.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.playGame();
    }
}
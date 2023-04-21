package main.java.ru.nsu.klochikhina.lab1503.task1.ui;

import main.java.ru.nsu.klochikhina.lab1503.task1.controller.Controller;
import main.java.ru.nsu.klochikhina.lab1503.task1.model.Model;
import main.java.ru.nsu.klochikhina.lab1503.task1.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.setListener(view);
        Controller controller = new Controller(model, view);
        controller.playGame();
    }
}
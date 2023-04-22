package main.java.ru.nsu.klochikhina.calculator.ui;

import main.java.ru.nsu.klochikhina.calculator.model.Run;
import main.java.ru.nsu.klochikhina.calculator.model.factory.Factory;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Factory.getCommandList());

        try {
            Run running = new Run();
            running.run();
        } catch (ArithmeticException exc){
            System.out.println("Поймана ошибка: деление на ноль " + exc);
        }
    }
}
package main.java.ru.nsu.klochikhina.calculator.ui;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Factory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // выполнять до ввода стоп-фразы?
        System.out.println(Factory.getCommandList() + "Пожалуйста, вводите команды без " +
                "использования дополнительных пробелов. Иначе это будет вопринято как ошибка.\n");
        try {
            Parsing.parsing();
        } catch (IOException exc) {
            System.out.println("Поймана ошибка: неверный ввод " + exc);
        } catch (ArithmeticException exc){
            System.out.println("Поймана ошибка: деление на ноль " + exc);
        }
    }
}
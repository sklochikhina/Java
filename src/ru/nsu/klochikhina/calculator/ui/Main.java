package ru.nsu.klochikhina.calculator.ui;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // выполнять до ввода стоп-фразы?
        try {
            Parsing.parsing();
        } catch (IOException exc) {
            System.out.println("Поймана ошибка: неверный ввод " + exc);
        } catch (ArithmeticException exc){
            System.out.println("Поймана ошибка: деление на ноль " + exc);
        }
    }
}
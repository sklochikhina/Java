package ru.nsu.klochikhina.calculator.ui;

import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Double> stack = new Stack<>();
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
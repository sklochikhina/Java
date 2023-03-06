package ru.nsu.klochikhina.calculator.ui;

import ru.nsu.klochikhina.calculator.model.Parsing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // выполнять до ввода стоп-фразы?
        try {
            Parsing.parsing();
        } catch (IOException exc){
            System.out.println("Поймана ошибка: неверный ввод " + exc);
        }

    }
}
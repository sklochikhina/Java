package main.java.ru.nsu.klochikhina.lab1702.task3.ui;

import main.java.ru.nsu.klochikhina.lab1702.task3.model.INIFileRead;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            INIFileRead.check();
        } catch (IOException exc) {
            System.out.println("Неверный ввод");
        } finally {
            System.out.println("Sum: " + INIFileRead.getSum());
        }

    }
}

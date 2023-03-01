package ru.nsu.Klochikhina.lab1702.task3.ui;

import ru.nsu.Klochikhina.lab1702.task3.model.INIFileRead;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        INIFileRead file = new INIFileRead();
        try {
            file.check();
        } catch (Exception exc) {
            throw exc;
        } finally {
            System.out.println("Sum: " + file.getSum());
        }

    }
}

package ru.nsu.klochikhina.lab0802.task4.ui;

import ru.nsu.klochikhina.lab0802.task4.model.RandomArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int N = scanner.nextInt();
        RandomArray obj = RandomArray.create(N);
        System.out.println("Минимальное число: " + obj.min() + "\nМаксимальное число: " + obj.max());
        scanner.close();
    }
}

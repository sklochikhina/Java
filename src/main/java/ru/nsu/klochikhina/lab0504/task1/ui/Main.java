package main.java.ru.nsu.klochikhina.lab0504.task1.ui;

import main.java.ru.nsu.klochikhina.lab0504.task1.model.Printer;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int N;  // количество потоков
        int M;  // количество строк

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество потоков: ");
        N = scanner.nextInt();
        System.out.println("Введите количество строк: ");
        M = scanner.nextInt();

        Semaphore[] semaphores = new Semaphore[N];

        for (int i = 0; i < N; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != 0)
                semaphores[i].acquire();
        }

        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new Printer(i, N, M, semaphores));
            threads[i].start();
        }

        for (int i = 0; i < N; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

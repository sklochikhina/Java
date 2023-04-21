package main.java.ru.nsu.klochikhina.lab1003.task1.ui;

import main.java.ru.nsu.klochikhina.lab1003.task1.model.Consumer;
import main.java.ru.nsu.klochikhina.lab1003.task1.model.Producer;
import main.java.ru.nsu.klochikhina.lab1003.task1.model.Storage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите N:");
        int N = scanner.nextInt();
        System.out.println("Введите P:");
        int P = scanner.nextInt();
        System.out.println("Введите C:");
        int C = scanner.nextInt();

        Storage<String> storage = new Storage<>(N);
        for (int i = 0; i < P; i++) {
            int finalI = i;
            Producer producer = new Producer(finalI){
                public synchronized void run() {
                    try {
                        while (!Thread.interrupted())
                            storage.put("p" + getID() + "-" + finalI);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            producer.start();
        }

        for (int i = 0; i < C; i++) {
            Consumer consumer = new Consumer(i){
                public synchronized void run() {
                    try {
                        while (!Thread.interrupted()) {
                            System.out.println("c"  + getID() + " consumes " + storage.take());
                            Thread.sleep(50);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            consumer.start();
        }

        System.exit(0);
    }
}

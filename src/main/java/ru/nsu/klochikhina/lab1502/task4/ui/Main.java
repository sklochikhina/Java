package main.java.ru.nsu.klochikhina.lab1502.task4.ui;

import main.java.ru.nsu.klochikhina.lab1502.task4.model.Signal;

import java.util.*;

enum Importance{
    SIMPLE,
    IMPORTANT,
    CRITICAL
}
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        Map<Signal, Importance> map = new LinkedHashMap<>();
        Random random  = new Random();
        int signals = random.nextInt(1000) + 1;

        for (int i = 0; i < signals; i++){
            int number = random.nextInt(3);
            Importance imprtnc;

            switch (number) {
                case (1): imprtnc = Importance.IMPORTANT; break;
                case (2): imprtnc = Importance.CRITICAL; break;
                default: imprtnc = Importance.SIMPLE;
            }

            Signal signal = new Signal();
            signal.num = i + 1;
            signal.intensity = Math.abs(random.nextInt());

            map.put(signal, imprtnc);
        }

        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
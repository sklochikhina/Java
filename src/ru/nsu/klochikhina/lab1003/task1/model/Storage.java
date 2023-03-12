package ru.nsu.klochikhina.lab1003.task1.model;

import java.util.ArrayList;

public class Storage<T> {
    private final int capacity;
    private int size = 0;
    private final ArrayList<T> array = new ArrayList<>();

    public Storage(int input){
        capacity = input;
    }

    public synchronized void put(T product) throws InterruptedException{
        if (size == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        size++;
        array.add(product);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        if (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        size--;
        String product = (String) array.get(size - 1);
        array.remove(size - 1);
        notifyAll();

        return product;
    }
}

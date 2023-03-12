package ru.nsu.klochikhina.lab1003.task1.model;

public class Consumer extends Thread{
    private final int id;

    public Consumer(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

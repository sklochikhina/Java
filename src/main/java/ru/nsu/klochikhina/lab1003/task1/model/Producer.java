package main.java.ru.nsu.klochikhina.lab1003.task1.model;

public class Producer extends Thread{
    private final int id;

    public Producer(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

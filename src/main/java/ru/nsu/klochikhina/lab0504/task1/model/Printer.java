package main.java.ru.nsu.klochikhina.lab0504.task1.model;

import java.util.concurrent.Semaphore;

public class Printer implements Runnable {
    private final int id;
    private final int N;
    private final int M;
    private final Semaphore[] semaphores;

    public Printer(int id, int numThreads, int numLines, Semaphore[] semaphores) {
        this.id = id;
        this.N = numThreads;
        this.M = numLines;
        this.semaphores = semaphores;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j < N; j++)
                    if (j != id)
                        semaphores[j].acquire();

                System.out.println(id + "-" + i);

                if (id != N - 1)
                    semaphores[id + 1].release();
                else
                    semaphores[0].release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

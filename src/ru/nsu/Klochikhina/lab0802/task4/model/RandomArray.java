package ru.nsu.Klochikhina.lab0802.task4.model;

import java.util.Random;

public abstract class RandomArray implements Maxer, Minner {
    int[] arr;

    RandomArray(int N){
        arr = new int[N];
        Random random = new Random();
        int min = -1000, max = 1000;
        for (int i = 0; i < N; i++)
            arr[i] = random.nextInt(2 * max) + min;
    }


    static public RandomArray create(int N){
        return new Child(N);
    }
}

class Child extends RandomArray{
    Child(int N){
        super(N);
    }
    public int min(){
        int min = 1000;
        for (int j : arr)
            if (j < min)
                min = j;
        return min;
    }

    public int max(){
        int max = -1000;
        for (int j : arr)
            if (j > max)
                max = j;
        return max;
    }
}

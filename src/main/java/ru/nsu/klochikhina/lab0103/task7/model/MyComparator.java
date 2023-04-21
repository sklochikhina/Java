package main.java.ru.nsu.klochikhina.lab0103.task7.model;

import java.util.Comparator;

public class MyComparator implements Comparator<Dot<Integer>> {

    @Override
    public int compare(Dot<Integer> o1, Dot<Integer> o2) {
        if (o1.getDistance() > o2.getDistance()) {
            return -1;
        } else if (o1.getDistance() < o2.getDistance()) {
            return 1;
        }
        return 0;
    }
}

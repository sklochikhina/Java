package main.java.ru.nsu.klochikhina.lab0103.task7.model;

public class Dot<T extends Number> {
    private final T x, y, z;
    private final double distance;
    public Dot(T X, T Y, T Z, double dist){
        x = X;
        y = Y;
        z = Z;
        distance = dist;
    }

    public double getDistance(){
        return distance;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", distance=" + distance +
                '}';
    }
}

package ru.nsu.klochikhina.lab0103.task7.ui;

import java.io.IOException;
import java.util.*;

import ru.nsu.klochikhina.lab0103.task7.model.*;

enum Mode{
    INCREASING,
    DECREASING
}

public class Main {
    public static void main(String[] args) throws Exception {

        TreeMap<Dot<Integer>, Color> tree = new TreeMap<>(new MyComparator());

        System.out.println("Выберите режим, в котором нужно вывести точки: возрастание расстояния от начала координат(1), " +
                "убывание расстояния от начала координат(2)");

        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input < 1 || input > 2)
                throw new Exception("Неверный ввод режима");

            Mode mode = Mode.INCREASING;
            if (input == 2)
                mode = Mode.DECREASING;

            createDots(tree);

            if (mode == Mode.DECREASING)
                for (Map.Entry entry: tree.entrySet())
                    System.out.println(entry.toString());
            else
                for (Map.Entry entry: tree.descendingMap().entrySet())
                    System.out.println(entry.toString());

        } catch (IOException exc){
            System.out.println("Неверный ввод режима");
        }
    }

    static void createDots(TreeMap<Dot<Integer>, Color> tree){
        Random random  = new Random();
        int dots = random.nextInt(1000) + 1;

        for(int i = 0; i < dots; i++){
            int number = random.nextInt(3);
            Color color;

            switch (number) {
                case (1): color = Color.RED; break;
                case (2): color = Color.BLUE; break;
                default: color = Color.WHITE;
            }

            Integer x = random.nextInt(1000), y = random.nextInt(1000), z = random.nextInt(1000);
            Dot<Integer> dot = new Dot<>(x, y, z, Math.sqrt(x*x + y*y + z*z));

            tree.put(dot, color);
        }
    }
}

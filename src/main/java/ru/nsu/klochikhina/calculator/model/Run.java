package main.java.ru.nsu.klochikhina.calculator.model;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import main.java.ru.nsu.klochikhina.calculator.model.factory.Factory;
import main.java.ru.nsu.klochikhina.calculator.ui.Parsing;

import java.util.*;

public class Run {

    private static final Stack<Double> stack = new Stack<>();
    private static final Map<String, Double> defineList = new HashMap<>();

    public void run() {
        Parsing pars = new Parsing(null);
        try {
            String[] arr;
            while (true){
                arr = pars.parsing();

                Factory factory = new Factory();
                Command command = factory.createCommand(arr, stack, defineList);

                switch (arr.length){
                    case 1: command.action(); break;
                    case 2: command.action(arr[1]); break;          //  PUSH
                    case 3: command.action(arr[1], arr[2]); break;  //  DEFINE
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public String fileName(){
        System.out.print("Введите имя файла, в котором содержатся команды: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }*/
}

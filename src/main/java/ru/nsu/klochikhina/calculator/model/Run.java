package main.java.ru.nsu.klochikhina.calculator.model;

import main.java.ru.nsu.klochikhina.calculator.model.factory.Command;
import main.java.ru.nsu.klochikhina.calculator.model.factory.Factory;
import main.java.ru.nsu.klochikhina.calculator.ui.Parsing;

import java.io.IOException;
import java.util.*;

public class Run {
    private final Stack<Double> stack;
    private final Map<String, Double> defineList;

    public Run(Stack<Double> stack, Map<String, Double> defineList) {
        this.stack = stack;
        this.defineList = defineList;
    }

    public boolean run() {
        Parsing pars = new Parsing(null);
        try {
            String[] arr = pars.parsing();

            if(arr == null) {
                System.out.println("Вы успешно завершили выполнение программы.");
                return true;
            }

            Factory factory = new Factory();
            Command command = factory.createCommand(arr, stack, defineList);

            try {
                switch (arr.length) {
                    case 1:
                        command.action();
                        break;
                    case 2:
                        command.action(arr[1]);         // PUSH
                        break;
                    case 3:
                        command.action(arr[1], arr[2]); // DEFINE
                        break;
                }
            } catch (ArithmeticException | IOException exc){
                System.err.println(exc.getMessage());
                return false;
            } catch (EmptyStackException exc){
                System.err.println("Ошибка: стек пуст!");
                return false;
            }
            return false;
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

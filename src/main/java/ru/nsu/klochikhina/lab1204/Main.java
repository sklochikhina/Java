package main.java.ru.nsu.klochikhina.lab1204;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к папке: ");
        String path = scanner.nextLine();
        List<File> files = FileUtils.getFilesInDirectory(path);
        System.out.println("Список файлов в папке " + path + ":");
        files.forEach(file -> System.out.println(file.getName()));
    }
}

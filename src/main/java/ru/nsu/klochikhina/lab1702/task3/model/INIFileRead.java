package main.java.ru.nsu.klochikhina.lab1702.task3.model;

import java.io.*;

public class INIFileRead {
    static float sum = 0;
    public static void check() throws IOException {
        File file = new File("G:\\Java\\Java_LABS\\src\\ru\\nsu\\Klochikhina\\lab1702\\task3\\ui\\file.ini.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            String[] str = line.split("=");
            if (str.length > 1 && isNumeric(str[1]))
                sum += Integer.parseInt (str[1]);
            line = reader.readLine();
        }
    }

    public static float getSum() {
        return sum;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

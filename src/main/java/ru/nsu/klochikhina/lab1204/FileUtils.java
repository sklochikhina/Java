package main.java.ru.nsu.klochikhina.lab1204;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import java.io.File;
import java.util.List;

public class FileUtils {
    public static List<File> getFilesInDirectory(String path) {
        File directory = new File(path);
        ImmutableList.Builder<File> builder = ImmutableList.builder();
        for (File file : Files.fileTraverser().depthFirstPreOrder(directory)) {
            builder.add(file);
        }
        return builder.build();
    }
}

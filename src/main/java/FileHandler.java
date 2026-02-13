//Author: Roshan Mahesh
//Part B
//Team: 1-2

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FileHandler {
    private static final String DATA_FOLDER = "data";

    public static List<String> listFiles() {
        List<String> files = new ArrayList<>();
        File folder = new File(DATA_FOLDER);

        if (folder.exists() && folder.isDirectory()) {
            File[] fileList = folder.listFiles();
            if (fileList != null) {
                for (File file : fileList) {
                    if (file.isFile()) {
                        files.add(file.getName());
                    }
                }
            }
        }
        Collections.sort(files);
        return files;
    }

    public static String readFile(String filename) throws IOException {
        Path filePath = Paths.get(DATA_FOLDER, filename);
        return Files.readString(filePath);
    }

    public static boolean fileExists(String filename) {
        Path filePath = Paths.get(DATA_FOLDER, filename);
        return Files.exists(filePath);
    }
}
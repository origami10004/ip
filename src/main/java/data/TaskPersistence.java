package data;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import task.Task;

import exceptions.BaronException;
import exceptions.FileException;

public class TaskPersistence {
    private static final Path SAVE_FILE = Paths.get("./data/tasks.txt");
    // TODO: Switch to JSON after setting up gradle dependencies

    public static void save(ArrayList<Task> tasks) throws BaronException {
        try {
            Path parentDir = SAVE_FILE.getParent();
            if (parentDir != null) {
                Files.createDirectories(parentDir);
            }

            if (Files.notExists(SAVE_FILE)) {
                Files.createFile(SAVE_FILE);
            }

            List<String> lines = tasks.stream()
                    .map(Task::serialize)
                    .toList();
            
            Files.write(SAVE_FILE, lines);
        } catch (Exception e) {
            throw new FileException(SAVE_FILE.toString());
        }

    }
}

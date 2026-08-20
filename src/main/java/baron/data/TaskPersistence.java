// javadocs created by AI

package baron.data;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import baron.task.Task;

import baron.exception.BaronException;
import baron.exception.FileException;

/**
 * Handles the persistence of tasks to and from a file.
 * This class provides methods to save the current list of tasks to a file
 */
public class TaskPersistence {
    /** The file path where tasks are saved. */
    private static final Path SAVE_FILE = Paths.get("./data/tasks.txt");
    // TODO: Switch to JSON after setting up gradle dependencies

    /**
     * Saves the current list of tasks to the specified file.
     * Each task is serialized and written to the file, one per line.
     * @param tasks the list of tasks to save
     * @throws BaronException if an error occurs while saving the tasks
     */
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
        } catch (IOException e) {
            throw new FileException(SAVE_FILE.toString());
        }

    }

    /**
     * Loads the list of tasks from the specified file.
     * Each line in the file is expected to be a serialized task.
     *
     * @return the list of loaded tasks
     * @throws BaronException if an error occurs while loading the tasks
     */
    public static ArrayList<Task> load() throws BaronException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (Files.exists(SAVE_FILE)) {
                List<String> lines = Files.readAllLines(SAVE_FILE);
                for (String line : lines) {
                    Task task = Task.deserialize(line);
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            throw new FileException(SAVE_FILE.toString());
        }
        return tasks;
    }
}

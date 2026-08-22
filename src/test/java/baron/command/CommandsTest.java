package baron.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baron.data.BaronState;
import baron.exception.BaronException;
import baron.exception.FormatException;
import baron.exception.IndexException;
import baron.task.Deadline;
import baron.task.Event;
import baron.task.Task;
import baron.task.Todo;

class CommandsTest {
    private static final Path SAVE_FILE = Path.of("./data/tasks.txt");

    private boolean saveFileExisted;
    private byte[] originalSaveFile;

    @BeforeEach
    void setUp() throws IOException {
        saveFileExisted = Files.exists(SAVE_FILE);
        if (saveFileExisted) {
            originalSaveFile = Files.readAllBytes(SAVE_FILE);
        }
        Files.deleteIfExists(SAVE_FILE);
        BaronState.init();
    }

    @AfterEach
    void restoreSaveFile() throws IOException {
        if (saveFileExisted) {
            Files.write(SAVE_FILE, originalSaveFile);
        } else {
            Files.deleteIfExists(SAVE_FILE);
        }
    }

    @Test
    void todo_validDescription_addsTodoTask() throws BaronException {
        Commands.TODO.execute("read book");

        assertEquals(1, BaronState.getTasks().size());
        Task task = BaronState.getTasks().get(0);
        assertInstanceOf(Todo.class, task);
        assertEquals("read book", task.getName());
    }

    @Test
    void todo_emptyDescription_throwsFormatException() {
        assertThrows(FormatException.class, () -> Commands.TODO.execute(""));
        assertTrue(BaronState.getTasks().isEmpty());
    }

    @Test
    void deadline_validDescriptionAndDate_addsDeadlineTask() throws BaronException {
        Commands.DEADLINE.execute("submit report /by 2025-08-20 14:30");

        assertEquals(1, BaronState.getTasks().size());
        Task task = BaronState.getTasks().get(0);
        assertInstanceOf(Deadline.class, task);
        assertEquals("submit report", task.getName());
    }

    @Test
    void deadline_missingByFormat_throwsFormatException() {
        assertThrows(
                FormatException.class,
                () -> Commands.DEADLINE.execute("submit report 2025-08-20"));
        assertTrue(BaronState.getTasks().isEmpty());
    }

    @Test
    void deadline_invalidDate_throwsBaronException() {
        assertThrows(
                BaronException.class,
                () -> Commands.DEADLINE.execute("submit report /by not a date"));
        assertTrue(BaronState.getTasks().isEmpty());
    }

    @Test
    void event_validDescriptionAndTimes_addsEventTask() throws BaronException {
        Commands.EVENT.execute("team meeting /from 2025-08-21 10:00 /to 2025-08-21 11:00");

        assertEquals(1, BaronState.getTasks().size());
        Task task = BaronState.getTasks().get(0);
        assertInstanceOf(Event.class, task);
        assertEquals("team meeting", task.getName());
    }

    @Test
    void event_missingTimeFormat_throwsFormatException() {
        assertThrows(
                FormatException.class,
                () -> Commands.EVENT.execute("team meeting /from 2025-08-21 10:00"));
        assertTrue(BaronState.getTasks().isEmpty());
    }

    @Test
    void markThenUnmark_validTask_updatesCompletionStatus() throws BaronException {
        BaronState.addTask(new Todo("read book"));

        Commands.MARK.execute("1");
        assertTrue(BaronState.getTasks().get(0).isDone());

        Commands.UNMARK.execute("1");
        assertFalse(BaronState.getTasks().get(0).isDone());
    }

    @Test
    void delete_validTaskNumber_deletesSpecifiedTask() throws BaronException {
        BaronState.addTask(new Todo("keep this task"));
        BaronState.addTask(new Todo("delete this task"));

        Commands.DELETE.execute("2");

        ArrayList<Task> remainingTasks = BaronState.getTasks();
        assertEquals(1, remainingTasks.size());
        assertEquals("keep this task", remainingTasks.get(0).getName());
    }

    @Test
    void delete_nonNumericTaskNumber_throwsFormatException() throws BaronException {
        BaronState.addTask(new Todo("keep this task"));

        assertThrows(FormatException.class, () -> Commands.DELETE.execute("one"));
        assertEquals(1, BaronState.getTasks().size());
    }

    @Test
    void delete_outOfRangeTaskNumber_throwsIndexException() throws BaronException {
        BaronState.addTask(new Todo("keep this task"));

        assertThrows(IndexException.class, () -> Commands.DELETE.execute("2"));
        assertThrows(IndexException.class, () -> Commands.DELETE.execute("0"));
        assertEquals(List.of("keep this task"),
                BaronState.getTasks().stream().map(Task::getName).toList());
    }
}

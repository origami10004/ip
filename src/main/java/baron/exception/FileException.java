package baron.exception;

/**
 * Signals that an error occurred while accessing a file.
 */
public class FileException extends BaronException {
    /**
     * Creates a file exception for a specific file path.
     *
     * @param filePath the path of the file that could not be accessed.
     */
    public FileException(String filePath) {
        super("Failed to access file: " + filePath);
    }
}

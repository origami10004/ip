package exceptions;

public class FileException extends BaronException {
	public FileException(String filePath) {
		super("Failed to access file: " + filePath);
	}
	
}

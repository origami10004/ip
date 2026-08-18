package exceptions;

public class FormatException extends BaronException {
	public FormatException(String commandName, String expectedFormat) {
		super("Invalid format for " + commandName + " command. Please use: " + expectedFormat);
	}
}

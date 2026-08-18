package exceptions;

public class IndexException extends BaronException{
	public IndexException(String collectionName) {
		super("Invalid " + collectionName + " index.");
	}
}

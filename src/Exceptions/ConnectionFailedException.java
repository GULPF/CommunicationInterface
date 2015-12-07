package Exceptions;

public class ConnectionFailedException extends CBRNException {

	public ConnectionFailedException(int status) {
		super("Status code: " + status);
	}
	
	public ConnectionFailedException() {}
}

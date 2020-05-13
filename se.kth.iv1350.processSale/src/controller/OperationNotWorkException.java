package controller;

/*
 * Throws when there is an operation failed with unknown reason.
 */
public class OperationNotWorkException extends Exception{
	
	/*
	 * Creates a instance with the specified message and the reason for failed operation.
	 * @param message - the exception message.
	 * @param reason - the exception that caused this exception.
	 */
	public OperationNotWorkException(String message, Exception reason){
		super(message, reason);
	}
}

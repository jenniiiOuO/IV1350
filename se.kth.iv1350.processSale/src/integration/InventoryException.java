package integration;

/*
 * Thrown when something goes wrong while communicating with the inventory.
 */
public class InventoryException extends Exception {

	/*
	 * Creates a instance with a specified message that caused the exception.
	 * @param message - message that describes the cause.
	 */
	public InventoryException(String message) {
		super(message);
	}
}

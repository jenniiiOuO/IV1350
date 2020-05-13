package integration;

/*
 * Thrown when the item artNr does not exist.
 */
public class DoesNotExistException extends Exception{
	String artNr;
	
	/*
	 * Creates a new instance of exception
	 * @param the artNr that does not exists.
	 */
	public DoesNotExistException(String artNr) {
		super("Item " + artNr + " does not exist.");
		this.artNr = artNr;
	}

}

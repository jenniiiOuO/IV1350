package integration;

/**
 * Denna klass skapar alla register som kommer att användas i programmet
 *
 */
public class Registerskapare 
{
	private Lagerkatalog lagerkatalog = new Lagerkatalog();
	
	/**
	 * Hämtar värden av lagerkatalogen
	 * @return information i lagerkatalog
	 */
	public Lagerkatalog getLagerkatalog()
	{
		return lagerkatalog;
	}
}

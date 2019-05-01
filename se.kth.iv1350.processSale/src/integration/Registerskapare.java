package integration;

/**
 * Denna klass skapar alla register som kommer att anv�ndas i programmet
 *
 */
public class Registerskapare 
{
	private Lagerkatalog lagerkatalog = new Lagerkatalog();
	
	/**
	 * H�mtar v�rden av lagerkatalogen
	 * @return information i lagerkatalog
	 */
	public Lagerkatalog getLagerkatalog()
	{
		return lagerkatalog;
	}
}

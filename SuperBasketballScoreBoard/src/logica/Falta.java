/**
 * 
 */
package logica;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Falta {

	private int id;

	/**
	 * Constructor de la clase
	 */
	public Falta(int id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Falta [id=" + id + "]";
	}
	
	
	
	
	
	
}

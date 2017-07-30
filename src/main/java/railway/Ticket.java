/**
 * 
 */
package railway;

/**
 * The Class Ticket.
 *
 * @author Shridhar
 */
public class Ticket {

	/** The source. */
	private String source;
	
	/** The destination. */
	private String destination;
	
	/** The number ofstops. */
	private int numberOfstops;
	
	/** The cost. */
	private double cost;
	
	/** The valid ticket. */
	private boolean validTicket;

	/** The date of purchace. */
	private String dateOfPurchace;
	
	private boolean returnTicket;
	
	/**
	 * Instantiates a new ticket.
	 *
	 * @param src the src
	 * @param dest the dest
	 */
	public Ticket(String src, String dest, boolean returnTicket) {
		this.source = src;
		this.destination = dest;
		this.returnTicket = returnTicket;
	}
	
	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the number ofstops.
	 *
	 * @return the number ofstops
	 */
	public int getNumberOfstops() {
		return numberOfstops;
	}

	/**
	 * Sets the number ofstops.
	 *
	 * @param numberOfstops the new number ofstops
	 */
	public void setNumberOfstops(int numberOfstops) {
		this.numberOfstops = numberOfstops;
	}

	/**
	 * Gets the date of purchace.
	 *
	 * @return the date of purchace
	 */
	public String getDateOfPurchace() {
		return dateOfPurchace;
	}

	/**
	 * Sets the date of purchace.
	 *
	 * @param dateOfPurchace the new date of purchace
	 */
	public void setDateOfPurchace(String dateOfPurchace) {
		this.dateOfPurchace = dateOfPurchace;
	}

	/**
	 * Checks if is valid ticket.
	 *
	 * @return true, if is valid ticket
	 */
	public boolean isValidTicket() {
		return validTicket;
	}

	/**
	 * Sets the valid ticket.
	 *
	 * @param validTicket the new valid ticket
	 */
	public void setValidTicket(boolean validTicket) {
		this.validTicket = validTicket;
	}

	public boolean isReturnTicket() {
		return returnTicket;
	}

	public void setReturnTicket(boolean returnTicket) {
		this.returnTicket = returnTicket;
	}

	
}

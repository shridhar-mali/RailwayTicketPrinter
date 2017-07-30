/**
 * 
 */
package railway.service;

import railway.Ticket;

/**
 * The Interface TicketService.
 *
 * @author Shridhar
 */
public interface TicketService {

	/**
	 * Process ticket.
	 *
	 * @param ticket the ticket
	 */
	void processTicket(Ticket ticket);
	
	/**
	 * Prints the ticket.
	 *
	 * @param ticket the ticket
	 * @return the string
	 */
	String printTicket(Ticket ticket);
	
}

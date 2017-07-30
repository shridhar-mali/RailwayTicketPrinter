package railway.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import railway.Ticket;
import railway.service.TicketService;

public class ChennaiTicketServiceImplTest {

	TicketService ticketService = new ChennaiTicketServiceImpl();
	
	@Test
	public void testEndDestinations() {
		Ticket ticket = new Ticket("CHENNAI BEACH", "TAMBARAM", false);
		ticketService.processTicket(ticket);
		assertSame("Cost doesnot match", 20.0d, ticket.getCost());
		assertSame("Stops are not atching", 17, ticket.getNumberOfstops());
		
		Ticket ticketReverse = new Ticket("TAMBARAM", "CHENNAI BEACH", false);
		ticketService.processTicket(ticketReverse);
		assertSame("Cost doesnot match", 20.0d, ticketReverse.getCost());
		assertSame("Stops are not atching", 17, ticketReverse.getNumberOfstops());
	}
	

	@Test
	public void testFirstScenorio() {
		Ticket ticket = new Ticket("GUINDY", "CHENNAI FORT", false);
		ticketService.processTicket(ticket);
		assertSame("Cost doesnot match", 15.0d, ticket.getCost());
	}

	@Test
	public void testSecondScenorio() {
		Ticket ticket = new Ticket("KODAMBAKKAM", "GUINDY", false);
		ticketService.processTicket(ticket);
		assertEquals("Cost doesnot match",10.0, ticket.getCost(), 0.0);
	}
	
	@Test
	public void testStartTwoStations() {
		Ticket ticket = new Ticket("CHENNAI BEACH", "CHENNAI PARK", false);
		ticketService.processTicket(ticket);
		assertSame("Cost doesnot match", 10.0d, ticket.getCost());
		
		Ticket ticket2 = new Ticket("CHENNAI PARK", "CHENNAI BEACH", false);
		ticketService.processTicket(ticket2);
		assertSame("Cost doesnot match", 10.0d, ticket2.getCost());
	}
	
	@Test
	public void testMidStations() {
		Ticket ticket = new Ticket("MEENAMBAKKAM", "CHROMEPET", false);
		ticketService.processTicket(ticket);
		assertSame("Cost doesnot match", 10.0d, ticket.getCost());
		
		Ticket ticket2 = new Ticket("CHROMEPET", "MEENAMBAKKAM", false);
		ticketService.processTicket(ticket2);
		assertSame("Cost doesnot match", 10.0d, ticket2.getCost());
	}
	

	@Test
	public void testReturnTicketCost() {
		Ticket ticket = new Ticket("CHENNAI BEACH", "CHENNAI PARK", true);
		ticketService.processTicket(ticket);
		assertSame("Cost doesnot match", 27.5d, ticket.getCost());
		
	}
}

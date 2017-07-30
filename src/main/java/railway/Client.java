package railway;

import java.util.Scanner;

import railway.service.TicketService;
import railway.service.impl.ChennaiTicketServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String srcStation = sc.nextLine();
		String destStation = sc.nextLine();
		String typeOfTicket = sc.nextLine();

		TicketService ticketService = new ChennaiTicketServiceImpl();
		Ticket ticket = new Ticket(srcStation.toUpperCase(), destStation.toUpperCase(),  isReturnTicketType(typeOfTicket));
		
		ticketService.processTicket(ticket);
		
		System.out.println(ticketService.printTicket(ticket));
		
		sc.close();
	}
	
	private static boolean isReturnTicketType(String typeOfTicket)
	{
		if(typeOfTicket.equalsIgnoreCase("return"))
		{
			return true;
		}
		else
			return false;
	}

}

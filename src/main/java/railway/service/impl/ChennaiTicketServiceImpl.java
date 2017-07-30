package railway.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import railway.ChennaiRailStation;
import railway.Ticket;
import railway.service.TicketService;

/**
 * The Class ChennaiTicketServiceImpl.
 */
public class ChennaiTicketServiceImpl implements TicketService {

	/** The station map. */
	private static Map<String, ChennaiRailStation> STATION_MAP = new HashMap<String, ChennaiRailStation>(
			18);

	/** The Constant BASIC_FARE. */
	private static final int BASIC_FARE = 10;

	/** The Constant COMPLETE_TRAVEL_FARE. */
	private static final int COMPLETE_TRAVEL_FARE = 20;

	/** The Constant EXTRA_FARE. */
	private static final double EXTRA_FARE = 5.0d;

	/** The Constant MIN_STATIONS. */
	private static final int MIN_STATIONS = 5;

	/** The Constant NEW_LINE. */
	private static final String NEW_LINE = "\n";

	/** The Constant STOPS_LABEL. */
	private static final String STOPS_LABEL = " stops";

	/** The Constant RS. */
	private static final String RS = " RS";

	/** The Constant INVALID_TICKET. */
	private static final String INVALID_TICKET = "Please enter valid src/dest";

	static {
		STATION_MAP.put("CHENNAI BEACH", ChennaiRailStation.CHENNAI_BEACH);
		STATION_MAP.put("CHENNAI PARK", ChennaiRailStation.CHENNAI_PARK);
		STATION_MAP.put("CHENNAI EGMORE", ChennaiRailStation.CHENNAI_EGMORE);
		STATION_MAP.put("CHETPET", ChennaiRailStation.CHETPET);
		STATION_MAP.put("CHROMEPET", ChennaiRailStation.CHROMEPET);
		STATION_MAP.put("MAMBALAM", ChennaiRailStation.MAMBALAM);
		STATION_MAP.put("MEENAMBAKKAM", ChennaiRailStation.MEENAMBAKKAM);
		STATION_MAP.put("NUNGAMBAKKAM", ChennaiRailStation.NUNGAMBAKKAM);
		STATION_MAP.put("PALLAVARAM", ChennaiRailStation.PALLAVARAM);
		STATION_MAP.put("PAZHAVANTHANGAL", ChennaiRailStation.PAZHAVANTHANGAL);
		STATION_MAP.put("SAIDAPET", ChennaiRailStation.SAIDAPET);
		STATION_MAP.put("TRISULAM", ChennaiRailStation.TRISULAM);
		STATION_MAP.put("TAMBARAM SANATORIUM", ChennaiRailStation.TAMBARAM_SANATORIUM);
		STATION_MAP.put("TAMBARAM", ChennaiRailStation.TAMBARAM);
		STATION_MAP.put("ST. THOMAS MOUNT", ChennaiRailStation.ST_THOMAS_MOUNT);
		STATION_MAP.put("GUINDY", ChennaiRailStation.GUINDY);
		STATION_MAP.put("CHENNAI FORT", ChennaiRailStation.CHENNAI_FORT);
		STATION_MAP.put("KODAMBAKKAM", ChennaiRailStation.KODAMBAKKAM);
	}

	/*
	 * Process ticket.
	 * 
	 */
	public void processTicket(Ticket ticket) {

		if ( isBlankStation(ticket) || isNotValidStationForRoute(ticket)) {
			ticket.setValidTicket(false);
			return;
		}
		ChennaiRailStation srcStation = STATION_MAP.get(ticket.getSource());
		ChennaiRailStation destStation = STATION_MAP.get(ticket
				.getDestination());

		// swap stations, if it is a reverse route.
		if (destStation.compareTo(srcStation) < 0) {
			srcStation = STATION_MAP.get(ticket.getDestination());
			destStation = STATION_MAP.get(ticket.getSource());
		}

		int numberOfStops = destStation.getStationNumber()
				- srcStation.getStationNumber();
		ticket.setNumberOfstops(numberOfStops);
		ticket.setCost(calculateCost(numberOfStops, ticket.isReturnTicket()));

		ticket.setDateOfPurchace(new Date().toString());
		ticket.setValidTicket(true);
	}
	
	private boolean isBlankStation(Ticket ticket)
	{
		return StringUtils.isBlank(ticket.getSource())
		|| StringUtils.isBlank(ticket.getDestination());
	}

	private boolean isNotValidStationForRoute(Ticket ticket)
	{
		return !STATION_MAP.containsKey(ticket.getSource()) || !STATION_MAP.containsKey(ticket.getDestination());
	}
	/**
	 * Calculate cost.
	 * 
	 * @param totalStops
	 *            the total stops
	 * @return the int
	 */
	private double calculateCost(int totalStops, boolean isReturnTicket) {
		double cost = 0;
		if (totalStops < MIN_STATIONS) {
			cost = BASIC_FARE;
		} else if (totalStops == 17) {
			cost = COMPLETE_TRAVEL_FARE;
		} else {
			cost = BASIC_FARE;
			double totalRemStops = totalStops - MIN_STATIONS;
			cost = (int) (Math.ceil(totalRemStops / MIN_STATIONS) * EXTRA_FARE)
					+ cost;
		}
		if(isReturnTicket)
		{
			cost = cost*1.75 + cost;
		}
		return cost;
	}

	/*
	 * returns the ticket content.
	 * 
	 */
	public String printTicket(Ticket ticket) {
		if (!ticket.isValidTicket()) {
			return INVALID_TICKET;
		}
		StringBuffer ticketDetails = new StringBuffer();
		ticketDetails.append(ticket.getDateOfPurchace());
		ticketDetails.append(NEW_LINE);
		ticketDetails.append(ticket.getSource());
		ticketDetails.append(NEW_LINE);
		ticketDetails.append(ticket.getDestination());
		ticketDetails.append(NEW_LINE);
		ticketDetails.append(ticket.getNumberOfstops());
		ticketDetails.append(STOPS_LABEL);
		ticketDetails.append(NEW_LINE);
		ticketDetails.append(ticket.getCost());
		ticketDetails.append(RS);

		return ticketDetails.toString();
	}

}

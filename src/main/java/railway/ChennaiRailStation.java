/**
 * 
 */
package railway;

/**
 * The Enum ChennaiRailStation.
 *
 * @author Shridhar
 */
public enum ChennaiRailStation {

	/** The chennai beach. */
	CHENNAI_BEACH(1),
	
	/** The chennai fort. */
	CHENNAI_FORT(2),
	
	/** The chennai park. */
	CHENNAI_PARK(3),
	
	/** The chennai egmore. */
	CHENNAI_EGMORE(4),
	
	/** The chetpet. */
	CHETPET(5),
	
	/** The nungambakkam. */
	NUNGAMBAKKAM(6),
	
	/** The kodambakkam. */
	KODAMBAKKAM(7),
	
	/** The mambalam. */
	MAMBALAM(8),
	
	/** The saidapet. */
	SAIDAPET(9),
	
	/** The guindy. */
	GUINDY(10),
	
	/** The st thomas mount. */
	ST_THOMAS_MOUNT(11),
	
	/** The pazhavanthangal. */
	PAZHAVANTHANGAL(12),
	
	/** The meenambakkam. */
	MEENAMBAKKAM(13),
	
	/** The trisulam. */
	TRISULAM(14),
	
	/** The pallavaram. */
	PALLAVARAM(15),
	
	/** The chromepet. */
	CHROMEPET(16),
	
	/** The tambaram sanatorium. */
	TAMBARAM_SANATORIUM(17),
	
	/** The tambaram. */
	TAMBARAM(18);
	
	/** The station number. */
	private int stationNumber;
	
	/**
	 * Instantiates a new chennai rail station.
	 *
	 * @param stationNumber the station number
	 */
	ChennaiRailStation(int stationNumber)
	{
		this.setStationNumber(stationNumber);
	}

	/**
	 * Gets the station number.
	 *
	 * @return the station number
	 */
	public int getStationNumber() {
		return stationNumber;
	}

	/**
	 * Sets the station number.
	 *
	 * @param stationNumber the new station number
	 */
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	
}

import java.text.DecimalFormat;

//Ticket class
public class Tickets {

	// Variable are declared and constants are initialized
	private static final double regularTicket = 3.50;
	private static final double juniorTicket = 2.50;
	private static final double seniorTicket = 1.00;
	private static final int dailyTicket = 10;
	private static final int weeklyTicket = 40;
	private int regularTickets;
	private int juniorTickets;
	private int seniorTickets;
	private int dailyTickets;
	private int weeklyTickets;

	// Default constructor
	public Tickets() {
		regularTickets = 0;
		juniorTickets = 0;
		seniorTickets = 0;
		dailyTickets = 0;
		weeklyTickets = 0;
	}

	/**
	 * @param regularTickets
	 * @param juniorTickets
	 * @param seniorTickets
	 * @param dailyTickets
	 * @param weeklyTickets  Constructor with 5 parameters
	 */
	public Tickets(int regularTickets, int juniorTickets, int seniorTickets, int dailyTickets, int weeklyTickets) {
		this.regularTickets = regularTickets;
		this.juniorTickets = juniorTickets;
		this.seniorTickets = seniorTickets;
		this.dailyTickets = dailyTickets;
		this.weeklyTickets = weeklyTickets;
	}

	/**
	 * @param anotherTicket Copy constructor with parameter Tickets Copies the
	 *                      values of object into another object
	 */
	public Tickets(Tickets anotherTicket) {
		this.dailyTickets = anotherTicket.dailyTickets;
		this.juniorTickets = anotherTicket.juniorTickets;
		this.seniorTickets = anotherTicket.seniorTickets;
		this.dailyTickets = anotherTicket.dailyTickets;
		this.weeklyTickets = anotherTicket.weeklyTickets;
	}

	// This method add the tickets
	public void addTickets(int regularTickets, int juniorTickets, int seniorTickets, int dailyTickets,
			int weeklyTickets) {
		this.regularTickets += regularTickets;
		this.juniorTickets += juniorTickets;
		this.seniorTickets += seniorTickets;
		this.dailyTickets += dailyTickets;
		this.weeklyTickets += weeklyTickets;
	}

	// This method returns the total value of the tickets
	public double ticketsTotal() {
		double totalPrice = (this.regularTickets * regularTicket) + (this.juniorTickets * juniorTicket)
				+ (this.seniorTickets * seniorTicket) + (this.dailyTickets * dailyTicket)
				+ (this.weeklyTickets * weeklyTicket);
		return totalPrice;

	}

	// This method returns the string of indicating the count of each ticket
	public String toString() {
		DecimalFormat twoDecimal = new DecimalFormat("#.00");
		String count = getRegularTickets() + " x $" + twoDecimal.format(regularTicket) + " + " + getJuniorTickets()
				+ " x $" + twoDecimal.format(juniorTicket) + " + " + getSeniorTickets() + " x $" + seniorTicket + " + "
				+ getDailyTickets() + " x $" + dailyTicket + " + " + getWeeklyTickets() + " x $" + weeklyTicket;
		return count;
	}

	// Accessors and mutators for non constant attributes
	public int getRegularTickets() {
		return regularTickets;
	}

	/**
	 * @param regularTickets
	 */
	public void setRegularTickets(int regularTickets) {
		this.regularTickets = regularTickets;
	}

	/**
	 * @param juniorTickets
	 */
	public void setJuniorTickets(int juniorTickets) {
		this.juniorTickets = juniorTickets;
	}

	/**
	 * @param seniorTickets
	 */
	public void setSeniorTickets(int seniorTickets) {
		this.seniorTickets = seniorTickets;
	}

	/**
	 * @param dailyTickets
	 */
	public void setDailyTickets(int dailyTickets) {
		this.dailyTickets = dailyTickets;
	}

	/**
	 * @param weeklyTickets
	 */
	public void setWeeklyTickets(int weeklyTickets) {
		this.weeklyTickets = weeklyTickets;
	}

	/**
	 * @return number of weeklyTickets
	 */
	public int getWeeklyTickets() {
		return weeklyTickets;
	}

	/**
	 * @return number of dailyTickets
	 */
	public int getDailyTickets() {
		return dailyTickets;
	}

	/**
	 * @return number of juniorTickets
	 */
	public int getJuniorTickets() {
		return juniorTickets;
	}

	/**
	 * @return number of seniorTickets
	 */
	public int getSeniorTickets() {
		return seniorTickets;
	}

	// Equals method returns the boolean value after comparing the two objects
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		} else {
			Tickets other = (Tickets) obj;
			return dailyTickets == other.dailyTickets && juniorTickets == other.juniorTickets
					&& regularTickets == other.regularTickets && seniorTickets == other.seniorTickets
					&& weeklyTickets == other.weeklyTickets;
		}
	}

}

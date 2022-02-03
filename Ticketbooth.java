
//Ticketbooth class
public class Ticketbooth {

	// Variables are declared
	private Tickets ticket;
	private OPUSCard[] opus;

	// Default constructor
	public Ticketbooth() {
		ticket = null;
		opus = null;
	}

	/**
	 * @param ticket
	 * @param opus   Parametric constructor
	 */
	public Ticketbooth(Tickets ticket, OPUSCard[] opus) {
		this.ticket = ticket;
		this.opus = opus;
	}

	/**
	 * @param obj
	 * @return true if both ticketbooths have equal total value of tickets
	 */
	public boolean equalTotalAmount(Ticketbooth obj) {
		if (this == obj) {
			return false;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		else {
			return (this.ticket.ticketsTotal() == obj.ticket.ticketsTotal());
		}
	}

	/**
	 * @param other
	 * @return true if both ticketbooths have equal number of tickets
	 */
	public boolean equalTickets(Ticketbooth other) {
		if (this == other) {
			return false;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		} else {
			return (ticket.equals(other.ticket));
		}
	}

	/**
	 * @return the number of opus cards
	 */
	public int getNumberOfOpus() {
		return this.opus.length;
	}

	/**
	 * @param card
	 * @return the new length of opus cards
	 */
	public int addOpus(OPUSCard card) {
		int count = this.getNumberOfOpus() + 1;
		OPUSCard[] newOpus = new OPUSCard[count];
		for (int i = 0; i < count; i++) {
			if (i != (count - 1)) {
				newOpus[i] = opus[i];
			} else {
				newOpus[i] = card;
			}
		}
		this.opus = newOpus;
		return this.getNumberOfOpus();
	}

	/**
	 * @param index
	 * @return true if card is removed
	 */
	public boolean removeOpus(int index) {

		int totalOpus = this.getNumberOfOpus()-1;
		if (index < 0 || index > totalOpus) {
			return false;
		} else {
			OPUSCard[] newOpus = new OPUSCard[totalOpus];
			int count=0;
			for (int i = 0; i <= totalOpus; i++) {
				if (i != index) {
					newOpus[count] = opus[i];
					count++;
				}
			}
			this.opus = newOpus;
		}
		return true;
	}

	/**
	 * @param month
	 * @param year
	 * @param index This method updates the expiration date of opus card
	 */
	public void updateDate(int month, int year, int index) {
		this.opus[index].updateMonth(month);
		this.opus[index].updateYear(year);
	}

	/**
	 * @param regularTickets
	 * @param juniorTickets
	 * @param seniorTickets
	 * @param dailyTickets
	 * @param weeklyTickets
	 * @return the new total value of tickets
	 */
	public double addTicket(int regularTickets, int juniorTickets, int seniorTickets, int dailyTickets,
			int weeklyTickets) {
		ticket.addTickets(regularTickets, juniorTickets, seniorTickets, dailyTickets, weeklyTickets);
		return (ticket.ticketsTotal());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return false;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		} else {
			Ticketbooth other = (Ticketbooth) obj;

			return (this.opus.length == other.opus.length && (this.getTotalAmount() == other.getTotalAmount()));
		}
	}

	@Override
	public String toString() {
		String tickets = this.ticket.toString();
		if (this.opus.length == 0) {
			return tickets + "\nNo OPUS cards\n";
		} else {
			int count = this.opus.length;
			String opus = "";
			for (int i = 0; i < count; i++) {
				opus += this.opus[i].toString() + "\n";
			}
			return tickets + "\n" + opus;
		}
	}

	/**
	 * @return the breakdown of tickets
	 */
	public String getTickets() {
		return ticket.toString();
	}

	/**
	 * @return the total value of tickets in ticketbooth
	 */
	public double getTotalAmount() {
		return this.ticket.ticketsTotal();
	}

}

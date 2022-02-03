import java.text.DecimalFormat;

//Opuscard class
public class OPUSCard {
	
	//Variable are declared
	private String cardType;
	private String name;
	private int monthExpiry;
	private int yearExpiry;

	//Default constructor
	public OPUSCard() {
		this.cardType = null;
		this.name = null;
		this.monthExpiry = 0;
		this.yearExpiry = 0;
	}

	/** 
	 * @param cardType
	 * @param name
	 * @param expiryMonth
	 * @param expiryYear
	 * Parametric constructor with 4 parameters, verifies if the month is between 1 and 12
	 */
	public OPUSCard(String cardType, String name, int expiryMonth, int expiryYear) {
		this.cardType = cardType;
		this.name = name;
		this.monthExpiry = checkMonth(expiryMonth);
		this.yearExpiry = expiryYear;
	}
	
	/**
	 * @param anotherOpus
	 * Copy constructor
	 */
	public OPUSCard(OPUSCard anotherOpus) {
		this.cardType=anotherOpus.cardType;
		this.name=anotherOpus.name;
		this.monthExpiry=checkMonth(anotherOpus.monthExpiry);
		this.yearExpiry=anotherOpus.yearExpiry;		
	}

	/** 
	 * @param month
	 * @return month or 0
	 */
	private static int checkMonth(int month) {
		if (month > 0 && month <= 12) {
			return month;
		} else {
			return 0;
		}
	}

	/** 
	 * @return type of card
	 */
	public String getCardType() {
		return cardType;
	}

	/** 
	 * @return name of card
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @return month of expiration
	 */
	public int getMonthExpiry() {
		return monthExpiry;
	}

	/** 
	 * @return year of expiration
	 */
	public int getYearExpiry() {
		return this.yearExpiry;
	}

	//This method returns the opus card details
	public String toString() {
		DecimalFormat pattern = new DecimalFormat("00");
		String newMonth = pattern.format(monthExpiry);

		return (cardType + "-" + name + "-" + newMonth + "/" + yearExpiry);
	}

	//This method updates the year of expiration
	public void updateYear(int year) {
		this.yearExpiry = year;
	}
	
	//This method updates the month of expiration
	public void updateMonth(int month) {
		this.monthExpiry = checkMonth(month);
	}

	//This method compares two opus
	public boolean equalTotalAmount(OPUSCard obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		else {
			return (this.cardType==obj.cardType && this.name==obj.name && this.monthExpiry==obj.monthExpiry
					&& this.yearExpiry== obj.yearExpiry);
		}
	} 
}

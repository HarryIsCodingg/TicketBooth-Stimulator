//-----------------------------------------------------------------------------------
// Assignment 4
// Written by: Harinder Partap Singh and 40076200
// For COMP 248 Section EC A 
//-----------------------------------------------------------------------------------

/*
 * This program produces the ticketbooth stimulator 
 * and display the content according to selection
 * Input: User selects from the option displayes
 * Output: Data is produced based upon the user input
 */

import java.util.Scanner;

//Driver class
public class Driver {

	// Static Objects are declared and initialized
	static Tickets ticket1 = new Tickets(5, 1, 0, 1, 1);
	static Tickets ticket2 = new Tickets(5, 5, 5, 5, 5);
	static Tickets ticket3 = new Tickets(0, 1, 1, 1, 1);

	static OPUSCard card1 = new OPUSCard("STL", "M. Cola", 8, 2024);
	static OPUSCard card2 = new OPUSCard("RTL", "C. Venus", 3, 2025);
	static OPUSCard card3 = new OPUSCard("STM", "Z. Poker", 10, 2022);
	static OPUSCard card4 = new OPUSCard("RTL", "F. Max", 12, 2021);
	static OPUSCard card5 = new OPUSCard("REM", "T. Flona", 4, 2023);
	static OPUSCard card6 = new OPUSCard("TRAMREM", "S. EaFL", 11, 2021);

	static OPUSCard[] cards1 = { card1, card2 };
	static OPUSCard[] cards2 = { card1, card3 };
	static OPUSCard[] cards3 = { card4, card5, card6 };
	static OPUSCard[] empty = {};

	static Ticketbooth booth1 = new Ticketbooth(ticket1, cards1);
	static Ticketbooth booth2 = new Ticketbooth(ticket1, cards2);
	static Ticketbooth booth3 = new Ticketbooth(ticket2, cards3);
	static Ticketbooth booth4 = new Ticketbooth(ticket3, empty);
	static Ticketbooth booth5 = new Ticketbooth(ticket3, empty);

	// Array of all the ticketbooth objects is created
	static Ticketbooth[] booths = { booth1, booth2, booth3, booth4, booth5 };
	static Scanner input = new Scanner(System.in);

	// Main method
	public static void main(String[] args) {

		// Displaying the welcome banner
		System.out.printf("====================================================================="
				+ "\n\n   Welcome to Concordia 2021 Fall Geek's Ticketbooth Application\n\n"
				+ "=====================================================================\n\n");
		boolean flag = true;
		int boothNumber = 0;

		// While loop is used until the user terminates the program
		while (flag) {

			// Method called displays the menu
			displayMessage();
			int options = input.nextInt();

			// Switch is used to control the different inputs from user
			switch (options) {
			case 1:
				allTicketBooths();
				break;
			case 2:
				System.out.print("Which Ticketbooth do you want to see the content of? (Enter number 0 to 4): ");
				boothNumber = input.nextInt();
				displayTicketBooth(checkNumber(boothNumber));
				break;
			case 3:
				sameAmount();
				break;
				
			case 4:
				sameTickets();
				break;
			case 5:
				equalTicketsOpus();
				break;
			case 6:
				System.out.print("Which Ticketbooth do you want to add a OPUS card to? (Enter number 0 to 4): ");
				boothNumber = input.nextInt();
				addOpus(checkNumber(boothNumber));
				break;
			case 7:
				System.out.print("Which Ticketbooth do you want to remove an OPUS card from? (Enter number 0 to 4): ");
				boothNumber = input.nextInt();
				remove(checkNumber(boothNumber));
				break;
			case 8:
				System.out.print("Which Ticketbooth do you want to update a opus card from? (Enter number 0 to 4): ");
				boothNumber = input.nextInt();
				updateDate(checkNumber(boothNumber));
				break;
			case 9:
				System.out.print("Which Ticketbooth do you want to add Tickets to? (Enter number 0 to 4): ");
				boothNumber = input.nextInt();
				addTickets(checkNumber(boothNumber));
				break;
			case 0:
				// This displays the closing banner
				System.out.println("Thank you for using Concordia Fall Geek's Ticketbooth application");
				flag = false;
				break;
			default:
				System.out.println("Sorry that is not a valid choice. Try again.");
			}
			System.out.println();
		}
		// Scanner is closed
		input.close();

	}

	// This method controls the menu
	public static void displayMessage() {

		System.out.print("What would you like to do?\n" + "   1. See the content of all Ticketbooths\n"
				+ "   2. See the content of one Ticketbooths\n"
				+ "   3. List Ticketbooths with same amount of tickets' values\n"
				+ "   4. List Ticketbooths with same Tickets amount\n"
				+ "   5. List Ticketbooths with same amount of tickets values and same number of OPUS cards\n"
				+ "   6. Add a OPUS card to an existing Ticketbooth\n"
				+ "   7. Remove an existing OPUS card from a Ticketbooth\n"
				+ "   8. Update the expiry date of an existing OPUS card\n" + "   9. Add Tickets to a Ticketbooth\n"
				+ "   0. To quit\n\n" + "Please enter your choice and press <Enter>:");
	}

	// This method displays all the ticketbooths
	public static void allTicketBooths() {
		int count = 0;
		System.out.println("Content of each Ticketbooth: \n---------------------");
		for (Ticketbooth booth : booths) {
			System.out.printf("Ticketbooth #%d:\n%s\n", count, booth.toString());
			count++;
		}
	}

	// This method displays the particular ticketbooth
	public static void displayTicketBooth(int num) {
		System.out.println(booths[num].toString());
	}

	// The method displays the ticketbooths which have same amount of money
	public static void sameAmount() {
		System.out.println("List of Ticketbooth with same amount of money:\n");
		for (int i = 0; i < booths.length; i++) {
			for (int j = i + 1; j < booths.length; j++) {
				if (booths[i].equalTotalAmount(booths[j])) {
					System.out.printf("%6sTicketbooth %d and %d both have %.1f\n", " ", i, j,
							booths[i].getTotalAmount());
					continue;
				}
			}
		}
	}

	// This method displays the ticketbooths with same tickets
	public static void sameTickets() {
		System.out.println("List of Ticketbooths with same Tickets amount:\n");
		for (int i = 0; i < booths.length; i++) {
			for (int j = i + 1; j < booths.length; j++) {
				if (booths[i].equalTickets(booths[j])) {
					System.out.printf("%6sTicketbooth %d and %d both have %s\n", " ", i, j, booths[i].getTickets());
					continue;
				}
			}
		}
	}

	// This method displays the ticketbooths with same tickets and opus cards
	public static void equalTicketsOpus() {
		System.out.println("List of Ticketbooths with same amount of tickets values and same number of OPUS cards: \n");
		for (int i = 0; i < booths.length; i++) {
			for (int j = i + 1; j < booths.length; j++) {
				if (booths[i].equals(booths[j])) {
					System.out.printf("\tTicketbooths %d and %d\n", i, j);
					continue;
				}
			}
		}
	}

	// This method add the opus card to the dezired ticketbooth
	public static void addOpus(int num) {

		System.out.print("Please enter the following information so that we may complete the transaction-"
				+ "\n--> Type of OPUS card (STL,RTL, etc ..): ");
		String type = input.next();
		System.out.print("--> Full name on OPUS card: ");
		String name = input.next();
		System.out.print("--> Expiry month number and year (seperate by a space): ");
		int expiryMonth = input.nextInt();
		int expiryYear = input.nextInt();

		int newLength = booths[num].addOpus(new OPUSCard(type, name, expiryMonth, expiryYear));

		System.out.printf("You now have %d OPUS cards\n", newLength);
	}

	// This method removes the opus card from the dezired ticketbooth
	public static void remove(int num) {
		int totalCards = booths[num].getNumberOfOpus() - 1;

		if ((totalCards + 1) == 0) {
			System.out.println("Sorry that Ticketbooth has no cards");
		} else {
			System.out.printf("Enter card number from 0 to %d: \n", totalCards);
			int toRemove = input.nextInt();

			if ((booths[num].removeOpus(toRemove)) == true) {
				System.out.println("Card was removed successfully");
			} else {
				System.out.println("Sorry that Ticketbooth has no card number " + toRemove);
			}
		}

	}

	// This method update the expiration date of the opus card and validates the
	// user input
	public static void updateDate(int num) {
		int totalCards = booths[num].getNumberOfOpus() - 1;
		if (totalCards < 0) {
			System.out.println("Sorry that Ticketbooth has no cards");
		} else {
			System.out.printf("Which card do you want to update? (Enter card number %d to %d):\n", 0, totalCards);

			boolean flag = true;
			while (flag) {
				int cardNumber = input.nextInt();
				if (cardNumber >= 0 && cardNumber <= totalCards) {
					System.out.print("Enter new expiry month number and year (seperate by a space): ");
					int month = input.nextInt();
					int year = input.nextInt();

					booths[num].updateDate(month, year, cardNumber);
					System.out.println("Expiry date updated.\n");
					flag = false;
				} else {
					System.out.printf(
							"Sorry but there is no card number %d\n--> Try again:\n(Enter card number %d to %d):\n",
							cardNumber, 0, totalCards);
				}
			}
		}
	}

	// This method adds the tickets to the dezired ticketbooth
	public static void addTickets(int num) {
		System.out.print("How many regualar, junior, senior, daily and weekly do you want to add?\n"
				+ "Enter 5 numbers seperated by a space: ");
		int regularticket = input.nextInt();
		int juniorticket = input.nextInt();
		int seniorticket = input.nextInt();
		int dailyticket = input.nextInt();
		int weeklyticket = input.nextInt();

		double total = booths[num].addTicket(regularticket, juniorticket, seniorticket, dailyticket, weeklyticket);
		System.out.printf("You now have $%.1f\n\n", total);
	}

	/**
	 * @param num
	 * @return true if the user has entered the correct ticketbooth This method
	 *         validates the user input and returns the boolean value
	 */
	public static int checkNumber(int num) {
		boolean flag = true;
		while (flag) {
			if (num >= 0 && num < 5) {
				return num;
			} else {

				System.out.printf("Sorry but there is no Ticketbooth number %d\n--> Try again: (Enter number 0 to 4): ",
						num);
				num = input.nextInt();
			}
		}
		return num;
	}
}

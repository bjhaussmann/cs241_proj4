/**
 * 
 */
package cs241_proj4;

import java.util.Scanner;
import java.io.*;

/**
 * @author Ben
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String command = "";
		Scanner scan = new Scanner(System.in);
		DirectedGraph<Integer> dg = new DirectedGraph<Integer>();
		
		Scanner city = new Scanner(new File("city.dat"));
		Scanner road = new Scanner(new File("road.dat"));
		
		while (city.hasNextLine())
		{
			CityNode newCity = new CityNode();
			dg.addVertex(read(city, newCity));
		}
		
		// Checks if command is not E to exit
		while (!command.equalsIgnoreCase("E")) {
			System.out.print("Command? ");
			command = scan.nextLine();

			switch (command.toUpperCase()) {
			case "Q":
				QCommand(dg);
				break;
			case "D":
				DCommand(dg);
				break;
			case "I":
				ICommand(dg);
				break;
			case "R":
				RCommand(dg);
				break;
			// Runs H command, which displays all the command to choose from
			case "H":
				System.out.println("Q  Query the city information by entering the city code.");
				System.out.println("D  Find the minimum distance between two cities.");
				System.out.println("I  Insert a road by entering two city codes and distance.");
				System.out.println("R  Remove an existing road by entering two city codes.");
				System.out.println("H  Display this message.");
				System.out.println("E  Exit.");
				break;
			// Runs E command, which exits the program
			case "E":
				System.out.print("Thank you for using my program.");
				break;
			// Catches if the command given is an option
			default:
				System.out.print("This is not a command. Type H for help.\n");
				break;
			}
		}
	}
	protected static int read(Scanner city, CityNode newCity)
	{
		int num = city.nextInt();
		LinkedListWithIterator<CityNode> cities = new LinkedListWithIterator<CityNode>();
		newCity.setNum(num);
		newCity.setAbbrev(city.next());
		newCity.setName(city.next());
		newCity.setPop(city.nextInt());
		newCity.setElev(city.nextInt());
		cities.add(newCity);
		return num;
	}
	protected class CityNode{
		private int num;
		private String abbrev;
		private String name;
		private int pop;
		private int elev;
		private CityNode next;
		
		public CityNode ()
		{
			this(0, null, null, 0, 0, null);
		}
		
		public CityNode (int num, String abbrev, String name, int pop, int elev, CityNode next)
		{
			this.num= num;
			this.abbrev = abbrev;
			this.name = name;
			this.pop = pop;
			this.elev = elev;
			this.next = next;
		}
		
		/**
		 * @return the num
		 */
		public int getNum() {
			return num;
		}

		/**
		 * @param num the num to set
		 */
		public void setNum(int num) {
			this.num = num;
		}

		/**
		 * @return the abbrev
		 */
		public String getAbbrev() {
			return abbrev;
		}

		/**
		 * @param abbrev the abbrev to set
		 */
		public void setAbbrev(String abbrev) {
			this.abbrev = abbrev;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the pop
		 */
		public int getPop() {
			return pop;
		}

		/**
		 * @param pop the pop to set
		 */
		public void setPop(int pop) {
			this.pop = pop;
		}

		/**
		 * @return the elev
		 */
		public int getElev() {
			return elev;
		}

		/**
		 * @param elev the elev to set
		 */
		public void setElev(int elev) {
			this.elev = elev;
		}

		/**
		 * @return the next
		 */
		public CityNode getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(CityNode next) {
			this.next = next;
		}
	}
}

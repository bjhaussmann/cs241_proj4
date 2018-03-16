/**
 * 
 */
package cs241_proj4;

import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

/**
 * @author Ben
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws FileNotFoundException {
		String command = "";
		Scanner scan = new Scanner(System.in);
		DirectedGraph<Integer> dg = new DirectedGraph<Integer>();
		
		Scanner city = new Scanner(new File("city.dat"));
		Scanner road = new Scanner(new File("road.dat"));
		LinkedListWithIterator<CityNode> cities = new LinkedListWithIterator<CityNode>();
		CityNode newCity = new CityNode();
		
		while (city.hasNext())
		{
			dg.addVertex(read(city, newCity, cities));
		}
		
		while (road.hasNext())
		{
			int city1, city2, dist;
			city1 = road.nextInt();
			city2 = road.nextInt();
			dist = road.nextInt();
			dg.addEdge(city1, city2, dist);
		}
		
		int begin, end;
		// Checks if command is not E to exit
		while (!command.equalsIgnoreCase("E")) {
			System.out.print("Command? ");
			command = scan.nextLine();

			switch (command.toUpperCase()) {
			case "Q":
				System.out.println("City Code: ");
				String abbrev = scan.nextLine();
				Iterator <CityNode> cityIT = cities.getIterator();
				boolean found = false;
				while (cityIT.hasNext() && found != true)
				{
					CityNode nextCity = cityIT.next();
					if (nextCity.abbrev == abbrev)
					{
						System.out.println(nextCity.num + "\t" + nextCity.abbrev + "\t" + nextCity.name + "\t" + nextCity.pop + "\t" + nextCity.elev);
						found = true;
					}
				}
				break;
			case "D":
				System.out.println("City codes: ");
				begin = getNum(cities, scan.next());
				end = getNum(cities, scan.next());
				StackInterface<Integer> path = null;
				int length = dg.getShortestPath(begin, end, path);
				System.out.println("The minimum distance between " + getName(cities, begin) + " and " + getName(cities, end) + " is " + length + "through route: " + path.toString());
				break;
			case "I":
				System.out.print("City codes and distance: ");
				begin = getNum(cities, scan.next());
				end = getNum(cities, scan.next());
				int dist = scan.nextInt();
				dg.addEdge(begin, end, dist);
				System.out.println("You have inserted a road from " + getName(cities, begin) + " to " + getName(cities, end) + " with a distance of " + dist + ".");
				break;
			case "R":
				System.out.print("City codes: ");
				begin = getNum(cities, scan.next());
				end = getNum(cities, scan.next());
				dg.removeEdge(begin, end);
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
				break;
			// Catches if the command given is an option
			default:
				System.out.print("This is not a command. Type H for help.\n");
				break;
			}
		}
		scan.close();
		city.close();
		road.close();
	}
	private static String getName(LinkedListWithIterator<CityNode> cities, int num) {
		Iterator <CityNode> cityIT = cities.getIterator();
		while (cityIT.hasNext())
		{
			CityNode nextCity = cityIT.next();
			if (nextCity.num == num)
			{
				return nextCity.name;
			}
		}
		return "";
	}
	private static int getNum(LinkedListWithIterator<CityNode> cities, String abbrev) {
		Iterator <CityNode> cityIT = cities.getIterator();
		while (cityIT.hasNext())
		{
			CityNode nextCity = cityIT.next();
			if (nextCity.abbrev == abbrev)
			{
				return nextCity.num;
			}
		}
		return 0;
	}
	protected static int read(Scanner city, CityNode newCity, LinkedListWithIterator<CityNode> cities)
	{
		int num = city.nextInt();
		newCity.setNum(num);
		newCity.setAbbrev(city.next());
		newCity.setName(city.next());
		String temp = newCity.getName();
		if(city.hasNextInt())
			newCity.setPop(city.nextInt());
		else
		{
			newCity.setName(temp.concat(" " + city.next()));
			newCity.setPop(city.nextInt());
		}
		newCity.setElev(city.nextInt());
		cities.add(newCity);
		return num;
	}
	protected static class CityNode{
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

import java.io.IOException;
import java.util.*;

public class ReservationManagerConsole {
	private  static LinkedList <Client> clients=new LinkedList();
	private static Scanner scan=new Scanner(System.in);
	private  static Theater theater;

	public static void addClient() {
	String lastname;
	String firstname;
	String address;
	int type;
	System.out.println("Lastname : ");
	lastname=scan.nextLine();
	System.out.println("Firstname : ");
	firstname=scan.nextLine();
	System.out.println("Address: ");
	address=scan.nextLine();
	System.out.println("Choose client type");
	System.out.println("1 - Client");
	System.out.println("2 - VIP");
	System.out.println("3 - Group");
	type=scan.nextInt();
	switch(type) {
	case 1:
		clients.add(new Client(lastname,firstname,address));
		System.out.println(clients.getLast());
		break;
		
	case 2:
		clients.add(new ClientVIP(lastname,firstname,address));
		System.out.println(clients.getLast());
		
	case 3:
		clients.add(new ClientVIP(lastname,firstname,address));
		System.out.println(clients.getLast());
	}
	
	//System.out.println(lastname+" "+firstname+" was added with success");
	}
	
	public static void listeClient() {
		for(Client client:clients) {
			System.out.println(client.getFullString());
		}
	}
	
	public static void removeClient() {
		listeClient();
		System.out.println("Please enter the id of the client to be removed or -1 to cancel the action");
		int id;
		Client selectedClient = null;
		try {
		id=scan.nextInt();
		for(Client client:clients) {
			if(client.getId() == id) {
				selectedClient=client;
				break;
			}
		}
		if(selectedClient!=null) {
			clients.remove(selectedClient);
		}
		if(selectedClient == null && id != -1) {
			System.err.println("Invalid selection");
			}
		
			} catch(RuntimeException ex) { // Catch potential error
			System.err.println("This is not a valid number !");
			scan.nextLine(); // Remove what provoke the error
			}
		
	}
	
	public static void showReservation() {
		listeClient();
		int row=0;
		int col=0;
		System.out.println("Please enter the id of the client to be removed or -1 to cancel the action");
		int id;
		
		int idSelectedClient=-1;
		try {
		id=scan.nextInt();
		
			for(int i=0; i<clients.size();i++) {
				if(clients.get(i).getId()==id) {
					idSelectedClient=id;
					break;
				}
			}
			if(idSelectedClient!=-1) {
			clients.get(idSelectedClient).getReservationCost();
		}
		if(idSelectedClient == -1 && id != -1) {
			System.err.println("Invalid selection");
			}
		
			} catch(RuntimeException ex) { // Catch potential error
			System.err.println("This is not a valid number !");
			scan.nextLine(); // Remove what provoke the error
			}
		
	}
	
	public static void loadingClient() {
		try {
			clients = Serializer.<LinkedList>loadFromFile("clients.bak"); // Load the object with Serializer
			//Client.setCurrentID(id);
			} catch(ClassNotFoundException ex) { // This exception occures when trying to load a class that no longer exist
			ex.printStackTrace();
			System.exit(-1);
			} catch(IOException ex) {
			ex.printStackTrace();
			System.exit(-1);
			}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String choice="a";
int row=0;
int col=0;



System.out.println("Welcome to the Reservation Manager");

//Theater theater=new Theater(8,8);
theater = new Theater("theater1.csv");

//loadingClient();

System.out.println("File theater1.csv loaded with success");

//System.out.println("What do you want to do (h for help)");
while(true) {

System.out.println(" \nWhat do you want to do (h for help)");
//création de l'objet scanner pour utiliser une de ses fonctions pour récupérer les valeurs entrées au clavier
Scanner sc=new Scanner(System.in);
choice=sc.nextLine();




switch (choice)
{
case "h":
	System.out.println("h: Print this help");
	System.out.println("q: Quit");
	System.out.println("st: Show Theater");
	System.out.println("mr: Make a Rservation");
	System.out.println("cr: Cancel a Reservation");
	System.out.println("lc: Show the client list");
	System.out.println("ac: Add a new client");
	System.out.println("rc: Remove a client");
	
	break;
	
case "q":
	System.out.println("Bye Bye");
	theater.save();
	try {
		Serializer.saveToFile("clients.bak", clients); // Save the object with Serializer
		} catch(IOException ex) {
		ex.printStackTrace(); // In case of exception, print the error stack
		System.exit(-1); // then quit
		}
	System.exit(0);
	break;

case "st":
	System.out.println(theater);
	break;

case "mr":
	listeClient();
	System.out.println("Please enter the id of the client to be removed or -1 to cancel the action");
	int id;
	
	int idSelectedClient=-1;
	try {
	id=scan.nextInt();
	
		for(int i=0; i<clients.size();i++) {
			if(clients.get(i).getId()==id) {
				idSelectedClient=id;
				break;
			}
		}
		if(idSelectedClient!=-1) {
		System.out.println(theater);
		System.out.println("Please enter row letter");
		row=sc.next().charAt(0)-65;
		System.out.println("Please enter line number");
		col=sc.nextInt();
		try {
		theater.makeReservation(row, col);
		clients.get(idSelectedClient).addSeat(theater.getSeats()[row][col]);
		//this.seats[row][col].setBooked(true);
		System.out.println(theater);
		}
		catch (InvalidActionException e) {
	    System.out.println(" /!\\This space is not valid for reservation! /!\\");
	    }
	}
	if(idSelectedClient == -1 && id != -1) {
		System.err.println("Invalid selection");
		}
	
		} catch(RuntimeException ex) { // Catch potential error
		System.err.println("This is not a valid number !");
		scan.nextLine(); // Remove what provoke the error
		}
	
	break;
	
case "cr":
	System.out.println(theater);
	System.out.println("Please enter row letter");
	row=sc.next().charAt(0)-65;//65 pour les majiscules  97 pour les miniscules
	System.out.println("Please enter line number");
	col=sc.nextInt();
	try {
	theater.cancelReservation(row, col);
	System.out.println(theater);
	}
	catch (InvalidActionException e) {
    System.out.println(" /!\\This space is not valid for cancelation! /!\\");
    }
	break;
	
case "lc":
	listeClient();
	break;
	
case "ac":
	addClient();
	break;
	
case "rc":
	removeClient();
	
case "sr":
	showReservation();
	break;
	
	

	
}
}
}
}
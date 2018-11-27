import java.io.*;
import java.util.*;

public class Client implements Serializable{
private static int currentID=0;
private int id;
private String lastname;
private String firstname;
private String address;
protected LinkedList <Seat> seats=new LinkedList();
public String categorie=""; 

public Client(String lastname, String firstname, String address) {
	
	this.id = currentID++;
	this.lastname = lastname;
	this.firstname = firstname;
	this.address = address;
}

public static void setCurrentID(int id) {
	currentID=id;
}

public int getId() {
	return id;
}

public String getLastname() {
	return lastname;
}

public String getFirstname() {
	return firstname;
}

public String getAddress() {
	return address;
}

@Override
public String toString() {
	return this.lastname + " " + firstname;
}
public String getFullString() {
	return "Client n°"+this.id+" : "+this.lastname+" "+this.firstname+" ("+this.address+")";
}

public void addSeat(Seat s) {
	seats.add(s);
}

public void removeSeat(Seat s) {
	seats.remove(s);
}

public List<Seat>getSeats(){
	return this.seats;
}

public void  getExplicitedCost() {
	
	for(Seat seat:seats) {
		
		System.out.println(seat+" ("+seat.getType().getPrice()+"€)");
		}
	
	
}


public void  getReservationCost() {
	double total=0;
	for(Seat seat:seats) {
		total+=seat.getType().getPrice();
	}
	System.out.println("Total : "+total);
	
}

}

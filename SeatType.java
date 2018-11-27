
public enum SeatType {
SCENE("S", -1.0),
OBSTACLE("X", -1.0),
FIRST_CATEGORY("a", 125.0),
SECOND_CATEGORY("b",80.0),
THIRD_CATEGORY("c",50.0),
FOURTH_CATEGORY("d",20.0),
FIFTH_CATEGORY("e",10.0);
	
private String symbole;
private double price;

private SeatType(String symbole, double price) {
	this.symbole = symbole;
	this.price = price;
}

public String getSymbole() {
	return symbole;
}

public double getPrice() {
	return price;
}

@Override
public String toString()
{
	return this.symbole;
}

public static SeatType getSeatTypeFromSymbole(String symbole){
	for(SeatType a:SeatType.values()) {
		if(a.getSymbole().equals(symbole.toLowerCase())||a.getSymbole().equals(symbole))
			return a;
	}
	return null;
	}
	





}

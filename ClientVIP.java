
public class ClientVIP extends Client{

	public ClientVIP(String lastname, String firstname, String address) {
		super(lastname, firstname, address);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getReservationCost() {
		double calcul=0;
		for(Seat seat:seats) {
			if(seat.getType().getSymbole().equals("a")) {
				calcul+=seat.getType().getPrice()*70.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -30.0% => "+calcul+"€)");
			}
			else if(seat.getType().getSymbole().equals("b")) {
				calcul+=seat.getType().getPrice()*80.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -20.0% => "+calcul+"€)");
			}
			else if(seat.getType().getSymbole().equals("c")) {
				calcul+=seat.getType().getPrice()*80.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -20.0% => "+calcul+"€)");
			}
			else
				calcul+=seat.getType().getPrice();
				System.out.println(seat+" ("+seat.getType().getPrice()+"€)");
		System.out.println("Total : "+calcul);
		}
		}
	
	@Override
	public void getExplicitedCost() {
		double calcul;
		for(Seat seat:seats) {
			if(seat.getType().getSymbole().equals("a")) {
				calcul=seat.getType().getPrice()*70.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -30.0% => "+calcul+"€)");
			}
			else if(seat.getType().getSymbole().equals("b")) {
				calcul=seat.getType().getPrice()*80.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -20.0% => "+calcul+"€)");
			}
			else if(seat.getType().getSymbole().equals("c")) {
				calcul=seat.getType().getPrice()*80.0/100.0;
			System.out.println(seat+" ("+seat.getType().getPrice()+"€ -20.0% => "+calcul+"€)");
			}
			else
				System.out.println(seat+" ("+seat.getType().getPrice()+"€)");
		
		
		}}

	@Override
	public String toString() {
		return super.toString() + "\"VIP\"";
	}
	

}

import java.io.*;

public class Seat implements Serializable {
private int row;
private int col;
private SeatType type;
private boolean isBooked;

public Seat(int row, int col, SeatType type, boolean isBooked) {
	this.row = row;
	this.col = col;
	this.type = type;
	this.isBooked = isBooked;
}

public int getRow() {
	return row;
}

public int getCol() {
	return col;
}

public SeatType getType() {
	return type;
}

public boolean isBooked() {
	return isBooked;
}

public void setBooked(boolean isBooked) {
	this.isBooked = isBooked;
}


@Override
public String toString() {
char rowLetter = (char) ('A' + row);
return ""+rowLetter+col;
}



}

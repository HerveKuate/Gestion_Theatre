import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Theater {
	private Seat[][] seats ;
	
	

	public Seat[][] getSeats() {
		return seats;
	}

	public Theater(int nbRow, int nbCol) {
		this.seats = new Seat [nbRow][nbCol];
		for(int i=0;i<nbRow;i++) {
			for(int j=0;j<nbCol;j++)
			{
				this.seats[i][j]=new Seat(i,j,SeatType.FIRST_CATEGORY,false);
			}
		}
	}
	
	public int getNbRow() {
		return this.seats.length;
	}
	
	public int getNbCol(int nombre) {
		return this.seats[nombre].length;
	}
	
	
	public String toString() {
		StringBuffer buf=new StringBuffer();
		for(int i=0;i<this.getNbRow();i++) {
			buf.append((char) ('A' + i)+" ");
				for(int j=0;j<this.getNbCol(0);j++)
				{
					if(this.seats[i][j].isBooked())
						buf.append(this.seats[i][j].getType().getSymbole().toUpperCase()+" ");
					else
						buf.append(this.seats[i][j].getType().getSymbole()+" ");
				}
				buf.append("\n");
			}
		buf.append("  ");
		for(int j=0;j<this.getNbCol(0);j++) {
			buf.append(j+" ");
		}
		return buf.toString();
		
}
	
	public void makeReservation(int row, int col)throws InvalidActionException{
		this.seats[row][col].setBooked(true);	
		}
	
	public void cancelReservation(int row, int col)throws InvalidActionException{
		this.seats[row][col].setBooked(false);	
		}
	
	
	 public Theater(String patch) {
		 File f = new File("theatre1.csv.bak");
		 if(f.exists() && !f.isDirectory()) { 
		 	try {
			 FileReader fr = new FileReader(f);
			 BufferedReader br = new BufferedReader(fr);
			 String sCurrentLine;
			 int nbRow;
			 int nbCol;
			 sCurrentLine = br.readLine();
					 
				Scanner scan = new Scanner(sCurrentLine);
				scan.useDelimiter(scan.delimiter()+"|;+"); // Add ; as a valid delimiter
			//je lis le nombre de ligne et de colonne	
			 nbRow=Integer.parseInt(scan.next());
			 nbCol=Integer.parseInt(scan.next());
			 this.seats=new Seat [nbRow][nbCol];
			 //je lis la disposition des places
			 for(int i=0;i<nbRow;i++) 
			 {
				 sCurrentLine = br.readLine();
					
						 
						scan = new Scanner(sCurrentLine);
						scan.useDelimiter(scan.delimiter()+"|;+");
						//System.out.println("Delimiter : "+scan.delimiter());
						for(int j=0;j<nbCol;j++)
						{
							String symbole=scan.next();
							this.seats[i][j]=new Seat(i,j,SeatType.getSeatTypeFromSymbole(symbole),Character.isUpperCase(symbole.charAt(0)));
						}
							
						
					
			}
			 	
			} catch (IOException e) {

				e.printStackTrace();

			}
			 
			 
		 }
		 else {
		try {

		 File file=new File(patch);
		 FileReader fr = new FileReader(file);
		 BufferedReader br = new BufferedReader(fr);
		 String sCurrentLine;
		 int nbRow;
		 int nbCol;
		 sCurrentLine = br.readLine();
				 
			Scanner scan = new Scanner(sCurrentLine);
			scan.useDelimiter(scan.delimiter()+"|;+"); // Add ; as a valid delimiter
		//je lis le nombre de ligne et de colonne	
		 nbRow=Integer.parseInt(scan.next());
		 nbCol=Integer.parseInt(scan.next());
		 this.seats=new Seat [nbRow][nbCol];
		 //je lis la disposition des places
		 for(int i=0;i<nbRow;i++) 
		 {
			 sCurrentLine = br.readLine();
				
					 
					scan = new Scanner(sCurrentLine);
					scan.useDelimiter(scan.delimiter()+"|;+");
					//System.out.println("Delimiter : "+scan.delimiter());
					for(int j=0;j<nbCol;j++)
					{
						String symbole=scan.next();
						this.seats[i][j]=new Seat(i,j,SeatType.getSeatTypeFromSymbole(symbole),Character.isUpperCase(symbole.charAt(0)));
					}
						
					
				
		}
		 	
		} catch (IOException e) {

			e.printStackTrace();

		}
		}
	 }
	 public void save() throws IOException {
		 FileWriter fw = new FileWriter("theatre1.csv.bak");
		 try {
		 //fw.write("MyText");
			 
			 StringBuffer buf=new StringBuffer();
			 buf.append(this.getNbRow()+";");
			 buf.append(this.getNbCol(0)+""+System.lineSeparator());
				for(int i=0;i<this.getNbRow();i++) {
					for(int j=0;j<this.getNbCol(0);j++)
						{
							if(this.seats[i][j].isBooked())
								buf.append(this.seats[i][j].getType().getSymbole().toUpperCase()+";");
							else
								buf.append(this.seats[i][j].getType().getSymbole()+";");
						}
						buf.append(System.lineSeparator());
					}
					
				fw.write(buf.toString());
				
			 
		 } catch(IOException ex) {
		 System.err.println(ex.getMessage());
		 System.exit(-1);
		 }
		 fw.close();
	 }
	 
}
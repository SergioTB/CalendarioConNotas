package version1;

//Sergio Tineo

public class Year extends CalendarUnit {
	
	public Year(int pYear) {
		super(pYear);
		setCurrentPos(pYear);
	}
	
	public int getYear() {
		return currentPos;
	}
	
	public boolean increment() {
		currentPos = currentPos + 1;
		return true;
		
	}
}
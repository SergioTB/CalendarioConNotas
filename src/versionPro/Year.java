package versionPro;

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
	
	public boolean isLeap() {
		boolean isL = (currentPos % 100 != 0 && currentPos % 4 == 0) || currentPos % 400 == 0;
		return isL;
	}
}
package version1;

//Sergio Tineo

public class Month extends CalendarUnit {
	
	private Year y;
	private int[] sizeIndex = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Month(int pcur, Year pYear) {
		super(pcur);
		setMonth(pcur, pYear);
	}
	
	public void setMonth(int pcur, Year pYear) {
		setCurrentPos(pcur);
		y = pYear;
	}
	
	public int getMonth() {
		return currentPos;
	}
	
	public int getMonthSize() {
		return sizeIndex[currentPos - 1];
	} 
	
	public boolean increment() {
		currentPos = currentPos + 1;
		if(currentPos > 12){
			return false;
		}else{
			return true;
		}
	}
}
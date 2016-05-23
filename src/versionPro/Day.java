package versionPro;

//Sergio Tineo

public class Day extends CalendarUnit{
	
	private Month m;

	public Day(int pDay, Month pMonth) {
            
		super(pDay);
		m = pMonth;
		setCurrentPos(pDay);
	}

	@Override
	public boolean increment() {
		currentPos = currentPos + 1;
		if(currentPos <= m.getMonthSize()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public int getDay(){
		return currentPos;
	}

	public void setDay(int pDay, Month pMonth) {
		// TODO Auto-generated method stub
		setCurrentPos(pDay);
		m = pMonth;
	}

}

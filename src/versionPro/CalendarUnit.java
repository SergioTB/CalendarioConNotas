package versionPro;

//Autor: Sergio Tineo

public abstract class CalendarUnit {
	
	public int currentPos;
	
	public CalendarUnit(int pCurrentPos){
		currentPos = pCurrentPos;
	}
	
	public void setCurrentPos(int pCurrentPos) {
		currentPos = pCurrentPos;
	}
	
	public abstract boolean increment();
		
	}

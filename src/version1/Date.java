package version1;

//Sergio Tineo

public class Date{
	
	private Day d;
	private Month m;
	private Year y;
	
	public Date(Day pDay, Month pMonth, Year pYear){
		y = pYear;
		m = pMonth;
		d = pDay;
		
		
	}
	
	public void increment(){
		if(!(d.increment())){
			if(!(m.increment())){
				y.increment();
				m.setMonth(1, y);
				d.setDay(1, m);	//HE TENIDO QUE A�ADIR ESTA LINEA �ES CORRECTO?
			}else{
				d.setDay(1, m);
			}
		}
	}

    public Day getD() {
        return d;
    }

    public Month getM() {
        return m;
    }

    public Year getY() {
        return y;
    }
        
        
	
	public String printDate(){
		return m.getMonth() + "/" + d.getDay() + "/" + y.getYear();
	}

}

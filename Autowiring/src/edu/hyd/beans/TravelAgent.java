package edu.hyd.beans;

public class TravelAgent {
	
	private TourList tl;
	
/*	TravelAgent(){
		System.out.println("TravelAgent > 0 param Contructor");
	}*/
	
/*	TravelAgent(TourList tl){
		this.tl=tl;
		System.out.println("TravelAgent > 1 param Constructor");
	}*/
	
	public void setTl(TourList tl) {
		this.tl = tl;
		System.out.println("TravelAgent > Setter Method Injected");		
	}
	
	@Override
	public String toString() {
		return "TravelAgent > " + tl;
	}
	
}

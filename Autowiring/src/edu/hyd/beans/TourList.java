package edu.hyd.beans;

import java.util.Arrays;

public class TourList {
	
	private String[] places;

	public void setPlaces(String[] places) {
		this.places = places;		
	}
	
	@Override
	public String toString() {
		return "TourList : places=" + Arrays.toString(places);
	}
	
}

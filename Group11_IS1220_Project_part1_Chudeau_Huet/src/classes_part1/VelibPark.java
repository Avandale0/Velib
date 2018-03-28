package classes_part1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VelibPark {
	
	ArrayList<Station> stationsList;
	
	VelibPark(int size, double dimensionX, double dimensionY) {
		this.stationsList = new ArrayList<Station>();
		int stationSize = 100;
		for (int i = 0; i<size; i++) {
			double randomX = Math.random()*2*dimensionX - dimensionX;
			double randomY = Math.random()*2*dimensionY - dimensionY;
			Location location = new Location(randomX, randomY);
			stationsList.add(new Station(stationSize, location));
		}
	}

	/**
	 * Returns the station with the most uses (rentals and drop-offs)
	 * @return instance of class Station
	 */
	public ArrayList<Station> getStationsList() {
		return stationsList;
	}


	public void setStationsList(ArrayList<Station> stationsList) {
		this.stationsList = stationsList;
	}
	
	/**
	 * returns the most used station of the park
	 * @return
	 */
	public Station mostUsedStation() {
		long maxUses = 0;
		Station stationMax = stationsList.get(0);
		for (Station station : this.stationsList) {
			if (station.uses > maxUses) {
				maxUses = station.uses;
				stationMax = station;
			}
		}
		return stationMax;
	}

	/**
	 * Returns the station which has been the least occupied in the past month
	 * @return
	 */	
	public Station leastOccupiedStation() {
		Calendar calendar = Calendar.getInstance();
		Date nowDate = calendar.getTime();
		int month = calendar.get(2);
		if (month == 0) {
			calendar.set(2,11);
		}
		else {
		calendar.set(2,month-1);
		}
		Date thenDate = calendar.getTime();
		double minRate = stationsList.get(0).occupationRate(thenDate, nowDate);
		Station minStation = stationsList.get(0);
		for (Station station : stationsList) {
			if (station.occupationRate(thenDate, nowDate) < minRate) {
				minRate = station.occupationRate(thenDate, nowDate);
				minStation = station;
			}
		}
		return minStation;
	}
	
}
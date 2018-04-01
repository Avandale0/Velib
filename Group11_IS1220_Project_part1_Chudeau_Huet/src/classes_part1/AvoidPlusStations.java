package classes_part1;

public class AvoidPlusStations implements RideStrategy{
	
	public AvoidPlusStations() {
	}
	
	
	public Station Destination(Location destination, Station start, VelibPark park) {
		double minDistance = start.location.Distance(destination);
		Station closestStation = start;
		for (Station station : park.stationsList) {
			if (station.location.Distance(destination) < minDistance && station.type != StationType.plus) {
				minDistance = station.location.Distance(destination);
				closestStation = station;
			}
		}
		if (closestStation != start) {
			return closestStation;
		}
		System.out.println("The quickest path is by foot");
		return null;
	}

}
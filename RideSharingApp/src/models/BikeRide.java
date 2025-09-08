package models;

public class BikeRide extends Ride {
	public BikeRide(String driverName) {
        super(driverName);
    }

    @Override
    public double calculateFare(double distance) {
        return 20 + (distance * 8);
    }

}

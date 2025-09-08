package models;

public class AutoRide extends Ride {
	public AutoRide(String driverName) {
        super(driverName);
    }

    @Override
    public double calculateFare(double distance) {
        return 30 + (distance * 10);
    }

}

package models;

public class CarRide extends Ride {
	public CarRide(String driverName) {
        super(driverName);
    }

    @Override
    public double calculateFare(double distance) {
        return 50 + (distance * 15);
    }

}

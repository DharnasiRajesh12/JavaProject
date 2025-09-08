package models;

public abstract class Ride {
	
	private String driverName;

    public Ride(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void startRide(String passengerName) {
        System.out.println("Driver " + driverName + " started the ride for " + passengerName);
    }

    public abstract double calculateFare(double distance);

}

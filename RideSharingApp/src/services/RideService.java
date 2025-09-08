package services;

import models.Ride;

public class RideService {
	
	public void startRide(Ride ride, String passengerName, double distance) {
        ride.startRide(passengerName);
        double fare = ride.calculateFare(distance);
        System.out.println("Total Fare: ₹" + fare);
    }

}

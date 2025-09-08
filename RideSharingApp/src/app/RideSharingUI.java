package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import models.*;
import services.*;

public class RideSharingUI {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RideSharingUI().createUI());
    }

    private void createUI() {
        JFrame frame = new JFrame("Ride Sharing App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel rideLabel = new JLabel("Select Ride:");
        String[] rides = {"Car", "Bike", "Auto"};
        JComboBox<String> rideBox = new JComboBox<>(rides);

        JLabel distLabel = new JLabel("Enter Distance (km):");
        JTextField distanceField = new JTextField();

        JLabel payLabel = new JLabel("Select Payment:");
        String[] payments = {"UPI", "Card", "Cash"};
        JComboBox<String> payBox = new JComboBox<>(payments);

        JLabel detailLabel = new JLabel("UPI ID / Card No:");
        JTextField detailField = new JTextField();

        JButton bookBtn = new JButton("Book Ride");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rideLabel); panel.add(rideBox);
        panel.add(distLabel); panel.add(distanceField);
        panel.add(payLabel); panel.add(payBox);
        panel.add(detailLabel); panel.add(detailField);
        panel.add(new JLabel("")); panel.add(bookBtn);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(new JScrollPane(output), BorderLayout.SOUTH);

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String rideType = (String) rideBox.getSelectedItem();
                    String paymentType = (String) payBox.getSelectedItem();
                    String details = detailField.getText().trim();
                    double distance = Double.parseDouble(distanceField.getText());

                    Ride ride = null;
                    switch (rideType) {
                        case "Car": ride = new CarRide("Ravi"); break;
                        case "Bike": ride = new BikeRide("Suresh"); break;
                        case "Auto": ride = new AutoRide("Anil"); break;
                    }

                    RideService rideService = new RideService();
                    rideService.startRide(ride, "Rajesh", distance);
                    double fare = ride.calculateFare(distance);

                    Payment payment = null;
                    switch (paymentType) {
                        case "UPI": payment = new UPIPayment(details); break;
                        case "Card": payment = new CardPayment(details); break;
                        case "Cash": payment = new CashPayment(); break;
                    }

                    PaymentService paymentService = new PaymentService();
                    paymentService.processPayment(payment, fare);

                    output.setText("Ride booked!\nDriver: " + ride.getDriverName() +
                                   "\nDistance: " + distance + " km" +
                                   "\nFare: ₹" + fare +
                                   "\nPayment: " + paymentType + " successful!");
                } catch (Exception ex) {
                    output.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReservationSystem extends JFrame implements ActionListener {

    private JButton addHotelButton;
    private JButton addRoomButton;
    private JButton addGuestButton;
    private JButton addReservationButton;
    private JButton retrieveDataButton;

    public HotelReservationSystem() {
        super("Hotel Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        addHotelButton = new JButton("Add Hotel");
        addRoomButton = new JButton("Add Room");
        addGuestButton = new JButton("Add Guest");
        addReservationButton = new JButton("Add Reservation");
        retrieveDataButton = new JButton("Retrieve Data");

        // Add action listeners to buttons
        addHotelButton.addActionListener(this);
        addRoomButton.addActionListener(this);
        addGuestButton.addActionListener(this);
        addReservationButton.addActionListener(this);
        retrieveDataButton.addActionListener(this);

        // Create panel to hold buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.add(addHotelButton);
        buttonPanel.add(addRoomButton);
        buttonPanel.add(addGuestButton);
        buttonPanel.add(addReservationButton);
        buttonPanel.add(retrieveDataButton);

        // Add panel to frame
        getContentPane().add(buttonPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addHotelButton) {
            // Implement logic for adding a hotel
            String hotelName = JOptionPane.showInputDialog("Enter Hotel Name:");
            if (hotelName != null && !hotelName.trim().isEmpty()) {
                System.out.println("Hotel added: " + hotelName);
            }
        } else if (e.getSource() == addRoomButton) {
            // Implement logic for adding a room
            String roomNumber = JOptionPane.showInputDialog("Enter Room Number:");
            if (roomNumber != null && !roomNumber.trim().isEmpty()) {
                System.out.println("Room added: " + roomNumber);
            }
        } else if (e.getSource() == addGuestButton) {
            // Implement logic for adding a guest
            String guestName = JOptionPane.showInputDialog("Enter Guest Name:");
            if (guestName != null && !guestName.trim().isEmpty()) {
                System.out.println("Guest added: " + guestName);
            }
        } else if (e.getSource() == addReservationButton) {
            // Implement logic for adding a reservation
            String guestName = JOptionPane.showInputDialog("Enter Guest Name for Reservation:");
            String roomNumber = JOptionPane.showInputDialog("Enter Room Number for Reservation:");
            String reservationDate = JOptionPane.showInputDialog("Enter Reservation Date (YYYY-MM-DD):");
            if (guestName != null && !guestName.trim().isEmpty() &&
                roomNumber != null && !roomNumber.trim().isEmpty() &&
                reservationDate != null && !reservationDate.trim().isEmpty()) {
                System.out.println("Reservation added for Guest: " + guestName + ", Room: " + roomNumber + ", Date: " + reservationDate);
            }
        } else if (e.getSource() == retrieveDataButton) {
            // Implement logic for retrieving data
            System.out.println("Retrieve Data button clicked");
            // In a real application, this would show the list of hotels, rooms, guests, and reservations.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelReservationSystem());
    }
}
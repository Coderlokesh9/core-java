import java.util.ArrayList;
import java.util.List;

// Hotel class
class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

// Room class
class Room {
    private String roomNumber;
    private boolean isAvailable;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true; // Room is available by default
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void freeRoom() {
        isAvailable = true;
    }
}

// Guest class
class Guest {
    private String name;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Reservation class
class Reservation {
    private Guest guest;
    private Room room;
    private String date;

    public Reservation(Guest guest, Room room, String date) {
        this.guest = guest;
        this.room = room;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "guest=" + guest.getName() +
                ", room=" + room.getRoomNumber() +
                ", date='" + date + '\'' +
                '}';
    }
}

// HotelReservationSystem class
class HotelReservationSystemBackend {
    private List<Hotel> hotels;
    private List<Guest> guests;
    private List<Reservation> reservations;

    public HotelReservationSystemBackend() {
        hotels = new ArrayList<>();
        guests = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addHotel(String hotelName) {
        hotels.add(new Hotel(hotelName));
    }

    public void addRoom(String hotelName, String roomNumber) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                hotel.addRoom(new Room(roomNumber));
                return;
            }
        }
        System.out.println("Hotel not found: " + hotelName);
    }

    public void addGuest(String guestName) {
        guests.add(new Guest(guestName));
    }

    public void addReservation(String guestName, String roomNumber, String date) {
        Guest guest = null;
        Room room = null;

        for (Guest g : guests) {
            if (g.getName().equalsIgnoreCase(guestName)) {
                guest = g;
                break;
            }
        }

        for (Hotel hotel : hotels) {
            for (Room r : hotel.getRooms()) {
                if (r.getRoomNumber().equalsIgnoreCase(roomNumber) && r.isAvailable()) {
                    room = r;
                    break;
                }
            }
        }

        if (guest != null && room != null) {
            room.bookRoom();
            Reservation reservation = new Reservation(guest, room, date);
            reservations.add(reservation);
            System.out.println("Reservation added: " + reservation);
        } else {
            System.out.println("Unable to create reservation. Guest or room not found or room is not available.");
        }
    }

    public void retrieveData() {
        System.out.println("Hotels:");
        for (Hotel hotel : hotels) {
            System.out.println(" - " + hotel.getName());
            for (Room room : hotel.getRooms()) {
                System.out.println("   Room: " + room.getRoomNumber() + " (Available: " + room.isAvailable() + ")");
            }
        }

        System.out.println("Guests:");
        for (Guest guest : guests) {
            System.out.println(" - " + guest.getName());
        }

        System.out.println("Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(" - " + reservation);
        }
    }
}
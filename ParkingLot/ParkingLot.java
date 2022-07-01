package ParkingLot;
import java.util.List;

 enum ParkingStatus {
    EMPTY,
    OCCUPIED;
}

enum VehicleType {
    BIKE,
    COMPACT,
    SEDAN,
    TRUCK
}

enum Size {
    SMALL,
    MEDIUM,
    LARGE;
}

public class ParkingLot {
    public String name;
    public String address;
    public List<Slot> slots; 

    public ParkingLot(String name, String address, List<Slot> slots) {
        this.name = name;
        this.address = address;
        this.slots = slots;
    }

    public class Slot {

        public String slotId;
        public ParkingStatus stauts;
        public Size size;
        public Vehicle vehicle;

        public Slot(String slotId, Size size) {
            this.slotId = slotId;
            this.size = size;
            this.stauts = ParkingStatus.EMPTY;
        }

        public boolean isEmpty() {
            return this.stauts == ParkingStatus.EMPTY;
        }

        public void parkVehicle(Vehicle vehicle) {
           
        }
    
    }

    public abstract class Vehicle {
        public String plate;
        public VehicleType type;

    }


    

    
}



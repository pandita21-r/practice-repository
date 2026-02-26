public class SynchronizedMethodPracticeParkingLotCounter {
    static class ParkingLot {
        private int capacity;
        private int carsInside;

        public ParkingLot(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Invalid capacity");
            }
            this.capacity = capacity;
        }

        public synchronized void enter() {
            if (carsInside == capacity) {
                throw new IllegalArgumentException("Parking lot is full.");
            }
            carsInside += 1;
            System.out.println("One car entered.");
        }

        public synchronized void exit() {
            if (carsInside == 0) {
                throw new IllegalArgumentException("Parking lot is empty");
            }
            carsInside -= 1;
            System.out.println("One car exited.");
        }

        public int getCarsInside() {
            return carsInside;
        }
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot(3);

        try {
            p.enter();
            p.enter();
            p.exit();
            System.out.println(p.getCarsInside());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


public class InheritancePracticeVehicleRentalSystem{
    static class Vehicle {
        protected String model;
        protected double rentalPrice;
        protected boolean rented = false;

        Vehicle(String model, double rentalPrice) {
            if (model == null) {
                throw new IllegalArgumentException("Model cannot be null.");
            }
            if (rentalPrice < 0) {
                throw new IllegalArgumentException("Rental price cannot be negative.");
            }
            this.model = model;
            this.rentalPrice = rentalPrice;
            this.rented = false;
        }

        void rent() {
            if (rented) {
                throw new IllegalStateException("Vehicle already rented.");
            }
            rented = true;
        }

        void returnVehicle() {
            if (!rented) {
                throw new IllegalStateException("Vehicle is not currently rented.");
            }
            rented = false;
        }

        public String getInfo() {
            return String.format("Model %s, Price: %.2f, Rented: %b", model, rentalPrice, rented);
        }
    }

    static class Car extends Vehicle {
        private int seatCount;

        Car(String model, double rentalPrice, int seatCount) {
            super(model, rentalPrice);
            if (seatCount < 1) {
                throw new IllegalArgumentException("Seat count cannot be >= 1.");
            }
            this.seatCount = seatCount;
        }

        @Override
        public String getInfo() {
            return String.format("%s, Seats: %d", super.getInfo(), seatCount);
        }
    }

    static public class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        Motorcycle(String model, double rentalPrice, boolean hasSidecar) {
            super(model, rentalPrice);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public String getInfo() {
            return String.format("%s, Sidecar: %b", super.getInfo(), hasSidecar);
        }
    }

    public static void main(String[] args) {

        Car car = new Car("Toyota Camry", 75.0, 5);
        Motorcycle moto = new Motorcycle("Honda Rebel", 40.0, false);

        car.rent(); 
        car.returnVehicle(); 

        System.out.println(car.getInfo());
        System.out.println(moto.getInfo());

    }
}

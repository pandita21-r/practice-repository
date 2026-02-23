package package1;

public class TestRoom3 {
    static class Vehicle {
        private String brand;
        private int maxSpeed;

        public void setBrand(String brand) {
            if (brand == null || brand.isBlank()) {
                System.out.println("Brand cannot be blank.");
                return;
            }
            this.brand = brand;
        }

        public void setMaxSpeed(int maxSpeed) {
            if (maxSpeed <= 0) {
                System.out.println("Speed must be positive.");
                return;
            }
            this.maxSpeed = maxSpeed;
        }

        public String getBrand() {
            return brand;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        public String describe() {
            return "A vehicle made by " + getBrand() + " with a max speed of " + getMaxSpeed() + " km/h.";
        }
    }

    static class Car extends Vehicle {
        public Car(String brand, int maxSpeed) {
            super.setBrand(brand);
            super.setMaxSpeed(maxSpeed);
        }

        @Override
        public String describe() {
            return "Car: " + super.getBrand() + " can go up to " + super.getMaxSpeed() + " km/h.";
        }
    }

    static class Motorcycle extends Vehicle {
        public Motorcycle(String brand, int maxSpeed) {
            super.setBrand(brand);
            super.setMaxSpeed(maxSpeed);
        }

        @Override
        public String describe() {
            return "Motorcycle: " + super.getBrand() + " reaches " + super.getMaxSpeed() + " km/h.";
        }
    }

    static class Bus extends Vehicle {
        public Bus(String brand, int maxSpeed) {
            super.setBrand(brand);
            super.setMaxSpeed(maxSpeed);
        }

        @Override
        public String describe() {
            return "Bus: " + super.getBrand() + " comfortably cruises at " + super.getMaxSpeed() + " km/h.";
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];

        vehicles[0] = new Car("Toyota", 180); 
        vehicles[1] = new Motorcycle("Yamaha", 220);
        vehicles[2] = new Bus("Volvo", 120);
        vehicles[3] = new Vehicle();
        vehicles[3].setBrand("GenericBrand");
        vehicles[3].setMaxSpeed(90);

        for(Vehicle v : vehicles){
            System.out.println(v.describe());
        }
    }
}

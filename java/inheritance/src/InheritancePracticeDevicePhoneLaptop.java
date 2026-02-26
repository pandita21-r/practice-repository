public class InheritancePracticeDevicePhoneLaptop{
    static class Device {

        protected String brand;
        protected String model;

        public Device(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public String getDetails() {
            return "Brand: " + brand + ", Model: " + model;
        }
    }

    static class Phone extends Device {
        private int storage;

        public Phone(String brand, String model, int storage) {
            super(brand, model);
            this.storage = storage;
        }

        @Override
        public String getDetails() {
            return super.getDetails() + ", Storage: " + storage + "GB";
        }
    }

    static class Laptop extends Device {
        private int ram;

        public Laptop(String brand, String model, int ram) {
            super(brand, model);
            this.ram = ram;
        }

        @Override
        public String getDetails() {
            return super.getDetails() + ", RAM: " + ram + "GB";
        }
    }

    public static void main(String[] args) {
        Phone p = new Phone("Samsung", "S21", 128);
        Laptop l = new Laptop("Lenovo", "ThinkPad", 16);

        System.out.println(p.getDetails());
        System.out.println(l.getDetails());
    }
}
// refactored version with private final fields and Proper polymorphic usage in main
/* 
public class TestRoom9 {

    // Abstract because a generic "Device" shouldn't be instantiated directly
    static abstract class Device {

        private final String brand;
        private final String model;

        public Device(String brand, String model) {
            if (brand == null || model == null) {
                throw new IllegalArgumentException("Brand and model cannot be null");
            }
            this.brand = brand;
            this.model = model;
        }

        // Protected getters for subclasses (controlled access)
        protected String getBrand() {
            return brand;
        }

        protected String getModel() {
            return model;
        }

        // Common string representation
        @Override
        public String toString() {
            return "Brand: " + brand + ", Model: " + model;
        }
    }

    static class Phone extends Device {

        private final int storage; // immutable

        public Phone(String brand, String model, int storage) {
            super(brand, model);
            if (storage <= 0) {
                throw new IllegalArgumentException("Storage must be positive");
            }
            this.storage = storage;
        }

        @Override
        public String toString() {
            return super.toString() + ", Storage: " + storage + "GB";
        }
    }

    static class Laptop extends Device {

        private final int ram; // immutable

        public Laptop(String brand, String model, int ram) {
            super(brand, model);
            if (ram <= 0) {
                throw new IllegalArgumentException("RAM must be positive");
            }
            this.ram = ram;
        }

        @Override
        public String toString() {
            return super.toString() + ", RAM: " + ram + "GB";
        }
    }

    public static void main(String[] args) {

        Device[] devices = {
            new Phone("Samsung", "S21", 128),
            new Laptop("Lenovo", "ThinkPad", 16)
        };

        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
*/

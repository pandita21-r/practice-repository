package package1;

public class TestRoom9 {
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

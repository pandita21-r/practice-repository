public class TestRoom3 {
    static class Device {
        private boolean poweredOn = false;

        public void powerOn() {
            if (poweredOn) {
                throw new IllegalStateException("Device is already ON");
            }
            poweredOn = true;
        }

        public void powerOff() {
            if (!poweredOn) {
                throw new IllegalStateException("Device is already OFF");
            }
            poweredOn = false;
        }

        public void useDevice() {
            if (!poweredOn) {
                throw new IllegalStateException("Device is OFF. Turn it ON first.");
            }
        }
    }

    public static void main(String[] args) {
        Device device = new Device();

        try {
            device.useDevice();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

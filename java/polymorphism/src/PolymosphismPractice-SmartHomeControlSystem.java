// NOT DONE YET!
// Uses interface and abstract classes.

package package1;

public class TestRoom4 {
    public interface Controllable {
        void turnOn();

        void turnOff();

        boolean isOn();

        String reportState();
    }

    enum DevicesStatus {
        OFFLINE,
        IDLE,
        ACTIVE
    }

    enum LightMode {
        WARM,
        COOL,
        NEUTRAL
    }

    enum ThermostatMode {
        HEATING,
        COOLING,
        STANDBY
    }

    enum Resolution {
        HD,
        FULL_HD,
        ULTRA_HD
    }

    static abstract class SmartDevice implements Controllable {
        private String name;
        private int powerUsageWatts;
        private DevicesStatus status;
        private boolean poweredOn;

        public SmartDevice(String name, int powerUsageWatts) {
            setName(name);
            setPowerUsageWatts(powerUsageWatts);
            this.name = name;
            this.powerUsageWatts = powerUsageWatts;
            this.status = DevicesStatus.OFFLINE;
            this.poweredOn = false;
        }

        public void setName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank.");
            }
            this.name = name;
        }

        public void setPowerUsageWatts(int watts) {
            if (watts <= 0) {
                throw new IllegalArgumentException("Power usage must be positive.");
            }
            this.powerUsageWatts = watts;
        }

        protected void setStatus(DevicesStatus status) {
            if (status == null) {
                throw new IllegalArgumentException("Status cannot be null.");
            }
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public int getPowerUsageWatts() {
            return powerUsageWatts;
        }

        public DevicesStatus getStatus() {
            return status;
        }

        @Override
        public boolean isOn() {
            return poweredOn;
        }

        @Override
        public void turnOn() {
            if (poweredOn == true) {
                throw new IllegalThreadStateException("Device is already ON.");
            }
            setStatus(DevicesStatus.ACTIVE);
        }

        @Override
        public void turnOff() {
            if (poweredOn == false) {
                throw new IllegalThreadStateException("Device is already OFF.");
            }
            setStatus(DevicesStatus.IDLE);
        }

        protected abstract String getDeviceType();

        protected abstract String getSpecificState();

        @Override
        public String reportState() {
            return getDeviceType() + "\"" + getName() + "\" is" + isOn() + "(" + getStatus() + "), "
                    + getSpecificState() + ", power = " + getPowerUsageWatts() + " W.";
        }
    }

    public class LightBulb extends SmartDevice {
        private int brightness;
        private LightMode mode;

        public LightBulb(String name, int powerUsageWatts, int brightness, LightMode mode) {
            super(name, powerUsageWatts);
            setBrightness(brightness);
            setMode(mode);
            this.brightness = brightness;
            this.mode = mode;
        }

        public void setBrightness(int brightness) {
            if (!(brightness >= 0 && brightness <= 100)) {
                throw new IllegalArgumentException("Brightness must be between 0 and 100");
            }
            this.brightness = brightness;
        }

        public void setMode(LightMode mode) {
            if (mode == null) {
                throw new IllegalArgumentException("Light mode cannot be null.");
            }
            this.mode = mode;
        }

        @Override
        protected String getDeviceType() {
            return "LightBulb";
        }
        @Override
        protected String getSpecificState(){
            return "brightness = " + brightness + "%, " + " mode = " + mode;
        }
    }

    public static void main(String[] args) {
    }
}

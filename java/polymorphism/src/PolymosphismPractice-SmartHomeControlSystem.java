// DONE! 
// Using interface is hard!

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
            if (poweredOn) {
                throw new IllegalThreadStateException("Device is already ON.");
            }
            this.poweredOn = true;
            setStatus(DevicesStatus.ACTIVE);
        }

        @Override
        public void turnOff() {
            if (!poweredOn) {
                throw new IllegalThreadStateException("Device is already OFF.");
            }
            this.poweredOn = false;
            setStatus(DevicesStatus.IDLE);
        }

        protected abstract String getDeviceType();

        protected abstract String getSpecificState();

        @Override
        public String reportState() {
            return getDeviceType() + "\"" + getName() + "\" is " + (isOn() ? "ON" : "OFF") + " (" + getStatus() + "), "
                    + getSpecificState() + ", power = " + getPowerUsageWatts() + "W.";
        }
    }

    public static class LightBulb extends SmartDevice {
        private int brightness;
        private LightMode mode;

        public LightBulb(String name, int powerUsageWatts, int brightness, LightMode mode) {
            super(name, powerUsageWatts);
            setBrightness(brightness);
            setMode(mode);
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
            return "LightBulb ";
        }

        @Override
        protected String getSpecificState() {
            return "brightness = " + brightness + "%, " + " mode = " + mode;
        }
    }

    public static class Thermostat extends SmartDevice {
        private double targetTemperature;
        private ThermostatMode mode;

        public Thermostat(String name, int powerUsageWatts, double targetTemperature, ThermostatMode mode) {
            super(name, powerUsageWatts);
            setTargetTemperature(targetTemperature);
            setMode(mode);
        }

        public void setTargetTemperature(double temp) {
            if (!(temp >= 15.0 && temp <= 30.0)) {
                throw new IllegalArgumentException("Temperature must be between 15.0 and 30.0.");
            }
            this.targetTemperature = temp;
        }

        public void setMode(ThermostatMode mode) {
            if (mode == null) {
                throw new IllegalArgumentException("Thermostat mode cannot be null.");
            }
            this.mode = mode;
        }

        @Override
        protected String getDeviceType() {
            return "Thermostat ";
        }

        @Override
        protected String getSpecificState() {
            return "temp = " + targetTemperature + "°C, mode = " + mode;
        }
    }

    public static class SecurityCamera extends SmartDevice {
        private boolean recording;
        private Resolution resolution;

        public SecurityCamera(String name, int powerUsageWatts, Resolution resolution) {
            super(name, powerUsageWatts);
            setResolution(resolution);
        }

        public void setResolution(Resolution resolution) {
            if (resolution == null) {
                throw new IllegalArgumentException("Resolution cannot be null.");
            }
            this.resolution = resolution;
        }

        public void startRecording() {
            if (!isOn()) {
                throw new IllegalStateException("Cannot start recording while device is OFF or OFFLINE.");
            }
            this.recording = true;
        }

        public void stopRecording() {
            this.recording = false;
        }

        @Override
        protected String getDeviceType() {
            return "SecurityCamera ";
        }

        @Override
        protected String getSpecificState() {
            return "recording = " + recording + ", resolution = " + resolution;
        }
    }

    public static void main(String[] args) {
        Controllable[] devices = new Controllable[3];
        devices[0] = new LightBulb("Living Room", 60, 80, LightMode.WARM);
        devices[1] = new Thermostat("Hallway", 1200, 22.0, ThermostatMode.HEATING);
        devices[2] = new SecurityCamera("Front Door", 15, Resolution.FULL_HD);
        for (Controllable d : devices) {
            d.turnOn();
        }

        if (devices[0] instanceof LightBulb bulb) {
            bulb.setBrightness(80);
            bulb.setMode(LightMode.WARM);
        }

        if (devices[1] instanceof Thermostat thermo) {
            thermo.setTargetTemperature(22.0);
            thermo.setMode(ThermostatMode.HEATING);
        }

        if (devices[2] instanceof SecurityCamera camera) {
            camera.startRecording();
        }
        for (Controllable c : devices) {
            System.out.println(c.reportState());
        }
    }
}

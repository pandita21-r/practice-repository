package package1;

public class TestRoom8 {

    enum MachineState {
        OFF,
        IDLE,
        BREWING
    }

    static class CoffeeMachine {
        private MachineState state = MachineState.OFF;

        public void turnOn() {
            if (state == MachineState.IDLE) {
                throw new IllegalStateException("Machine is already on.");
            }
            if (state == MachineState.BREWING) {
                throw new IllegalStateException("Cannot turn on while brewing.");
            }
            state = MachineState.IDLE;
        }

        public void brew() {
            if (state == MachineState.OFF) {
                throw new IllegalStateException("Machine is off. Cannot brew.");
            }
            if (state == MachineState.BREWING) {
                throw new IllegalStateException("Already brewing.");
            }
            state = MachineState.BREWING;
        }

        public void finishBrewing() {
            if (state == MachineState.IDLE) {
                throw new IllegalStateException("Not brewing right now.");
            }
            if (state == MachineState.OFF) {
                throw new IllegalStateException("Machine is off.");
            }
            state = MachineState.IDLE;
        }

        public void turnOff() {
            if (state == MachineState.OFF) {
                throw new IllegalStateException("Machine is already off.");
            }
            if (state == MachineState.BREWING) {
                throw new IllegalStateException("Cannot turn off while brewing.");
            }
            state = MachineState.OFF;
        }

        public MachineState getState() {
            return state;
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();

        try {
            machine.turnOn();
            machine.brew();
            machine.finishBrewing();
            machine.turnOff();
            System.out.println(machine.getState());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

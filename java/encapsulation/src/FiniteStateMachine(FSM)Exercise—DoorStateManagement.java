package package1;

public class TestRoom8 {
    enum DoorStates {
        OPEN,
        CLOSED,
        LOCKED
    }

    static class Door {
        private DoorStates door = DoorStates.CLOSED;

        public synchronized void open() {
            if (door == DoorStates.LOCKED) {
                throw new IllegalStateException("Cannot open a locked door.");
            }
            if (door == DoorStates.OPEN) {
                throw new IllegalStateException("Door is already open.");
            }
            if (door == DoorStates.CLOSED) {
                door = DoorStates.OPEN;
            }
        }

        public void close() {
            if (door == DoorStates.CLOSED) {
                throw new IllegalStateException("Door is already closed.");
            }
            if (door == DoorStates.LOCKED) {
                throw new IllegalStateException("Cannot close a locked door.");
            }
            if (door == DoorStates.OPEN) {
                door = DoorStates.CLOSED;
            }
        }

        public synchronized void lock() {
            if (door == DoorStates.OPEN) {
                throw new IllegalStateException("Cannot lock an open door");
            }
            if (door == DoorStates.LOCKED) {
                throw new IllegalStateException("Door is already locked.");
            }
            if (door == DoorStates.CLOSED) {
                door = DoorStates.LOCKED;
            }
        }
        public void unlock(){
           if(door != DoorStates.LOCKED){
                throw new IllegalStateException("Door is not locked.");
           }
           if(door == DoorStates.LOCKED){
            door = DoorStates.CLOSED;
           }
        }
        public DoorStates getState(){
            return door;
        }
    }
    public static void main(String[] args) {
        Door d = new Door();

        try{
            d.open();
            d.close();
            d.lock();
            System.out.println(d.getState());
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        } 
    }
}

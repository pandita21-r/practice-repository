// Encapsulation practice but i used string for object state
// Don't know how to use enum yet hehe


public class EncapsulationWithMultiStateValidation{
    static class Order {
        private String status = "CREATED";

        public void confirmOrder() {
            if (status.equals("CREATED")) {
                this.status = "CONFIRMED";
            } else {
                throw new IllegalStateException("Order cannot be confirmed in its current state");
            }
        }

        public void shipOrder() {
            if (status.equals("CONFIRMED")) {
                status = "SHIPPED";
            } else {
                throw new IllegalStateException("Order cannot be shipped in its current state");
            }
        }

        public void cancelOrder() {
            if (status.equals("CREATED") || status.equals("CONFIRMED")) {
                status = "CANCELLED";
            } else {
                throw new IllegalStateException("Order cannot be cancelled in its current state");
            }
        }

        public String getStatus() {
            return status;
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        
        try{
            order.shipOrder();
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}

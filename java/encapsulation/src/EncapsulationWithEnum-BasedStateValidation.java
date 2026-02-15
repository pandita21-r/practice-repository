// Not fully safe hehe because of multiple thread acces.
// 2/14/26 Refactor with "synchronized" to avoid multiple thread access or race condition. It is safe now even if there is a shared mutable object hehe
// Concurrency is HARD!

package package1;

public class TestRoom5 {
    enum OrderStatus{
        CREATED,
        CONFIRMED,
        SHIPPED,
        CANCELLED
    }
    static class Order{
        private OrderStatus status = OrderStatus.CREATED;

        public synchronized void confirmOrder(){
            if(status == OrderStatus.CREATED){
               status = OrderStatus.CONFIRMED;
            } else{
                throw new IllegalStateException("Order cannot be confirmed in its current state");
            }
        }
        public synchronized void shipOrder(){
            if(status == OrderStatus.CONFIRMED){
                status = OrderStatus.SHIPPED;
            } else{
                throw new IllegalStateException("Order cannot be shipped in its current state");
            }
        }
        public synchronized void cancelOrder(){
            if(status == OrderStatus.CREATED || status == OrderStatus.CONFIRMED){
                status = OrderStatus.CANCELLED;
            } else{
                throw new IllegalStateException("Order cannot be cancelled in its current state");
            }
        }
        public synchronized OrderStatus getStatus(){
            return status;
        }
    }
    public static void main(String[] args) {
        Order order = new Order();

        try{
        // Behavioral Abstraction: Intent-revealing abstraction (order.shipOrder();)
        // Expose the INTENT instead of MECHANISM.
        order.shipOrder();
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}

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

        public void confirmOrder(){
            if(status == OrderStatus.CREATED){
               status = OrderStatus.CONFIRMED;
            } else{
                throw new IllegalStateException("Order cannot be confirmed in its current state");
            }
        }
        public void shipOrder(){
            if(status == OrderStatus.CONFIRMED){
                status = OrderStatus.SHIPPED;
            } else{
                throw new IllegalStateException("Order cannot be shipped in its current state");
            }
        }
        public void cancelOrder(){
            if(status == OrderStatus.CREATED || status == OrderStatus.CONFIRMED){
                status = OrderStatus.CANCELLED;
            } else{
                throw new IllegalStateException("Order cannot be cancelled in its current state");
            }
        }
        public OrderStatus getStatus(){
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

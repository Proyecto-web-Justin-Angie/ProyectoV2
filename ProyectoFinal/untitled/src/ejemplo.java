public class ejemplo {

// OrderState Interface
    interface OrderState {
        void pay(Order order);
        void pack(Order order);
        void ship(Order order);
        void deliver(Order order);
        void cancel(Order order);
        void review(Order order);
    }

// Order Class (Context)
    class Order {

        private int orderId;
        private String customerName;
        private OrderState state;

        public Order(int orderId, String customerName) {

            this.orderId = orderId;
            this.customerName = customerName;

            this.state = new CreatedState();

        }

        public void setState(OrderState state) {

            this.state = state;

        }

        public void pay() {

            state.pay(this);

        }

        public void pack() {

            state.pack(this);

        }

        public void ship() {

            state.ship(this);

        }

        public void deliver() {

            state.deliver(this);

        }

        public void cancel() {

            state.cancel(this);

        }

        public void review() {

            state.review(this);

        }

    }


// ===============================
// CreatedState
// ===============================

    class CreatedState implements OrderState {

        public void pay(Order order) {

            System.out.println("Order paid.");
            order.setState(new PaidState());

        }

        public void cancel(Order order) {

            System.out.println("Order cancelled.");
            order.setState(new CancelledState());

        }

        public void pack(Order order) {

            System.out.println("Cannot pack before payment.");

        }

        public void ship(Order order) {

            System.out.println("Cannot ship yet.");

        }

        public void deliver(Order order) {

            System.out.println("Cannot deliver yet.");

        }

        public void review(Order order) {

            System.out.println("Review not allowed.");

        }

    }


// ===============================
// PaidState
// ===============================

    class PaidState implements OrderState {

        public void pack(Order order) {

            System.out.println("Order packed.");
            order.setState(new PackedState());

        }

        public void pay(Order order) {

            System.out.println("Already paid.");

        }

        public void ship(Order order) {

            System.out.println("Cannot ship before packing.");

        }

        public void deliver(Order order) {

            System.out.println("Cannot deliver yet.");

        }

        public void cancel(Order order) {

            System.out.println("Cannot cancel after payment.");

        }

        public void review(Order order) {

            System.out.println("Review not allowed.");

        }

    }


// ===============================
// PackedState
// ===============================

    class PackedState implements OrderState {

        public void ship(Order order) {

            System.out.println("Order shipped.");
            order.setState(new ShippedState());

        }

        public void pay(Order order) {

            System.out.println("Already paid.");

        }

        public void pack(Order order) {

            System.out.println("Already packed.");

        }

        public void deliver(Order order) {

            System.out.println("Cannot deliver yet.");

        }

        public void cancel(Order order) {

            System.out.println("Cannot cancel after packing.");

        }

        public void review(Order order) {

            System.out.println("Review not allowed.");

        }

    }


// ===============================
// ShippedState
// ===============================

    class ShippedState implements OrderState {

        public void deliver(Order order) {

            System.out.println("Order delivered.");
            order.setState(new DeliveredState());

        }

        public void cancel(Order order) {

            System.out.println("Cannot cancel after shipment.");

        }

        public void pay(Order order) {

            System.out.println("Already paid.");

        }

        public void pack(Order order) {

            System.out.println("Already packed.");

        }

        public void ship(Order order) {

            System.out.println("Already shipped.");

        }

        public void review(Order order) {

            System.out.println("Review not allowed.");

        }

    }


// ===============================
// DeliveredState
// ===============================

    class DeliveredState implements OrderState {

        public void review(Order order) {

            System.out.println("Review submitted.");

        }

        public void pay(Order order) {}

        public void pack(Order order) {}

        public void ship(Order order) {}

        public void deliver(Order order) {}

        public void cancel(Order order) {

            System.out.println("Cannot cancel delivered order.");

        }

    }


// ===============================
// CancelledState
// ===============================

    class CancelledState implements OrderState {

        public void pay(Order order) {

            System.out.println("Order already cancelled.");

        }

        public void pack(Order order) {

            System.out.println("Order already cancelled.");

        }

        public void ship(Order order) {

            System.out.println("Order already cancelled.");

        }

        public void deliver(Order order) {

            System.out.println("Order already cancelled.");

        }

        public void cancel(Order order) {

            System.out.println("Order already cancelled.");

        }

        public void review(Order order) {

            System.out.println("Order already cancelled.");

        }

    }


// ===============================
// Client Class
// ===============================

    class Client {

        public static void main(String[] args) {

            Order order = new Order(1, "John Doe");

            order.pay();
            order.pack();
            order.ship();
            order.deliver();
            order.review();

        }

    }
}

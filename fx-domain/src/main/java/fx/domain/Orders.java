package fx.domain;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#getOrdersForAnAccount">
 * Orders for an account
 * </a>
 * This will return all pending orders for an account. Note: pending take profit or stop loss orders are recorded in the
 * open trade object, and will not be returned in this request.
 */
public class Orders {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

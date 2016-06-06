package fx.service;

import fx.domain.Orders;

import java.util.Map;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/">
 * Information about orders for an account
 * </a>
 */
public class OrdersService {
    /**
     * <a href="http://developer.oanda.com/rest-live/orders/#getOrdersForAnAccount">
     * Get a list of pending orders for an account
     * </a>
     *
     * @param accountID id of user's account
     * @param params    HashMap of parameters, adding to request
     * @return Orders
     * @throws ServiceHttpException
     */
    public Orders getAll(int accountID, Map<String, String> params) throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts/" + accountID + "/orders");
        if (params != null) {
            for (String paramName : params.keySet()) {
                hb.parameter(paramName, params.get(paramName));
            }
        }
        Response resp = hb.authorization().get().execute();

        if (resp.getCode() == 200) {
            JsonSerializationService<Orders> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), Orders.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }
}

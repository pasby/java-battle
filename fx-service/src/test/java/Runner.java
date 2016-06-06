import fx.domain.*;
import fx.service.*;

import java.util.HashMap;

/**
 * Simple demo class for presentation of http-server
 */
public class Runner {
    public static void main(String[] args) {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/prices");
        Response resp = hb.parameter("instruments", "EUR_USD")
                .authorization()
                .get()
                .execute();
        System.out.println(resp);

        AccountsService accServ = new AccountsService();
        Accounts domAccs;
        try {

            domAccs = accServ.getAll(); // obtain Accounts object
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }

        for (Account i : domAccs.getAccounts()) { // Accounts is a List of AccountsService objects
            System.out.println("List of accounts:");
            System.out.println(i.getAccountName() + " " + i.getAccountId());
        }

        /* AccountsService.getAccountInformation method */
        int accId = domAccs.getAccounts().get(0).getAccountId();
        AccountInformation accInfo;
        try {
            accInfo = accServ.getAccountInformation(accId);
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        System.out.println(accInfo.getAccountName() + " " +
                accInfo.getAccountId() + " " +
                accInfo.getBalance() + " " +
                accInfo.getAccountCurrency() + " " +
                accInfo.getOpenOrders() + " " +
                accInfo.getOpenTrades() + " " +
                accInfo.getMarginAvail() + " " +
                accInfo.getMarginUsed() + " " +
                accInfo.getMarginRate());

        /* OrdersService.getAll method */
        OrdersService ordServ = new OrdersService();
        HashMap<String, String> params = new HashMap<>();
        params.put("count", "15");
        params.put("instrument", "EUR_USD");
        Orders orders;
        try {
            orders = ordServ.getAll(accId, params); // obtain Orders object
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }
        for (Order order : orders.getOrders()) { // Orders is a List of Order objects
            System.out.println(order.getId() + " " +
                    order.getInstrument() + " " +
                    order.getUnits() + " " +
                    order.getPrice() + " " +
                    order.getType()
            );
        }

    }
}

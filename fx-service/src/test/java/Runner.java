import fx.domain.Account;
import fx.domain.AccountInformation;
import fx.domain.Accounts;
import fx.service.AccountsService;
import fx.service.HttpBuilder;
import fx.service.Response;
import fx.service.ServiceHttpException;

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
    }
}

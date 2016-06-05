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
                .header("Authorization", "Bearer " + System.getenv("oandatoken"))
                .get()
                .execute();
        System.out.println(resp);

        fx.domain.Accounts domAccs;
        try {
            domAccs = fx.service.Account.getAll(); // obtain fx.domain.Accounts object
        } catch (ServiceHttpException ex) {
            System.out.println("Http error code: " + ex.getCode());
            ex.printStackTrace();
            return;
        }

        for (fx.domain.Account i : domAccs.getAccounts()) { // fx.domain.Accounts is a List of fx.domain.Account objects
            System.out.println("List of accounts:");
            System.out.println(i.getAccountName() + " " + i.getAccountId());
        }

        int accId = domAccs.getAccounts().get(0).getAccountId();
    }
}

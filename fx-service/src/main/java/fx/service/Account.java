package fx.service;

/**
 * <a href="http://developer.oanda.com/rest-live/accounts/">
 *     Information about user account
 * </a>
 */
public class Account {
    /**
     * <a href="http://developer.oanda.com/rest-live/accounts/#getAccountsForUser">
     *     Get a list of accounts owned by the user
     * </a>
     * @return fx.domain.Accounts
     * @throws ServiceHttpException
     */
    public static fx.domain.Accounts getAll() throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts");
        Response resp = hb.header("Authorization", "Bearer " + System.getenv("oandatoken")).get().execute();
        if (resp.getCode() == 200) {
            JsonSerializationService<fx.domain.Accounts> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), fx.domain.Accounts.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }
}

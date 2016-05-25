package fx.service;

/**
 * Simple demo class for presentation of http-server
 */
public class Runner {
    public static void main(String[] args) {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/prices");
        Response resp = hb.parameter("instruments", "USD_EUR")
                .header("Authorization", "Bearer " + System.getenv("oandatoken"))
                .get()
                .execute();
        System.out.println(resp);
    }
}

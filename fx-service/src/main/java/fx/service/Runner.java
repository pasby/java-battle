package fx.service;

/**
 * Simple demo class for presentation of http-server
 */
public class Runner {
    public static void main(String[] args) {
        HttpBuilder hb = new HttpBuilder("http://bash.im");
        Response resp = hb.get().execute();
        System.out.println(resp);
    }
}

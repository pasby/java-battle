package fx.service;

/**
 * Simple demo class for presentation of http-server
 */
public class Runner {
    public static void main(String[] args) {
        HttpBuilder hb = new HttpBuilder("http://bash.im/index");
        Response resp = hb.parameter("text", "root").get().execute();
        System.out.println(resp);
    }
}

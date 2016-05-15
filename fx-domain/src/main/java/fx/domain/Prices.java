package fx.domain;

import java.util.List;

/**
 * http://developer.oanda.com/rest-live/rates/#getCurrentPrices
 * Fetch live prices for specified instruments that are available on the OANDA platform
 */
public class Prices {
    private List<Price> prices;

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}

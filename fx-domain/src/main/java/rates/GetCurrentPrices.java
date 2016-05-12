package rates;


public class GetCurrentPrices {
    public String getInstruments() {
        return instruments;
    }

    public void setInstruments(String instruments) {
        this.instruments = instruments;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    private String instruments;
    private String since; // Optional parameter. Time in RFC3339 format. Use java.text.SimpleDateFormat.
}

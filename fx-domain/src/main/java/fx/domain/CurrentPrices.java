package fx.domain;

import fx.domain.Instruments.Instrument;

public class CurrentPrices {

    private Instrument instruments;
    private String since; // Optional parameter. Time in RFC3339 format. Use java.text.SimpleDateFormat.

    public Instrument getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument instruments) {
        this.instruments = instruments;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

}

package rates;

public class RetrieveInstrumentHistory {
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCandleFormat() {
        return candleFormat;
    }

    public void setCandleFormat(String candleFormat) {
        this.candleFormat = candleFormat;
    }

    public String getIncludeFirst() {
        return includeFirst;
    }

    public void setIncludeFirst(String includeFirst) {
        this.includeFirst = includeFirst;
    }

    public String getDailyAlignment() {
        return dailyAlignment;
    }

    public void setDailyAlignment(String dailyAlignment) {
        this.dailyAlignment = dailyAlignment;
    }

    public String getAlignmentTimezone() {
        return alignmentTimezone;
    }

    public void setAlignmentTimezone(String alignmentTimezone) {
        this.alignmentTimezone = alignmentTimezone;
    }

    public String getWeeklyAlignment() {
        return weeklyAlignment;
    }

    public void setWeeklyAlignment(String weeklyAlignment) {
        this.weeklyAlignment = weeklyAlignment;
    }

    private String instrument; // only required parameter
    private String granularity;
    private String count;
    private String start;
    private String end;
    private String candleFormat;
    private String includeFirst;
    private String dailyAlignment;
    private String alignmentTimezone;
    private String weeklyAlignment;

}

package pizza.guodomorr.pl.pizzashark.model.restaurants;

/**
 * Created by lukasz on 18.10.15.
 */
public class Opening {
    private String from;
    private String until;
    private Integer day;

    public Opening() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Opening{" +
                "from='" + from + '\'' +
                ", until='" + until + '\'' +
                ", day=" + day +
                '}';
    }
}

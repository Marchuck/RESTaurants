package pizza.guodomorr.pl.pizzashark.model.location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 10.10.15.
 */
public class Rating {
    private Integer count;
    private Double average;
    private List<Last> last = new ArrayList<Last>();

    public Rating() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public List<Last> getLast() {
        return last;
    }

    public void setLast(List<Last> last) {
        this.last = last;
    }
}

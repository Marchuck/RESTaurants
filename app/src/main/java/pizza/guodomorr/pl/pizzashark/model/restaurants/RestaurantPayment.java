package pizza.guodomorr.pl.pizzashark.model.restaurants;

/**
 * Created by lukasz on 18.10.15.
 */
public class RestaurantPayment {

    private String payment;
    private Integer fee;

    @Override
    public String toString() {
        return "RestaurantPayment{" +
                "payment='" + payment + '\'' +
                ", fee=" + fee +
                '}';
    }

    public RestaurantPayment() {
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}

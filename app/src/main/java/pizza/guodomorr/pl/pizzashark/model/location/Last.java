package pizza.guodomorr.pl.pizzashark.model.location;

/**
 * Created by lukasz on 10.10.15.
 */
public class Last {
    private Boolean advice;
    private String author;
    private String date;
    private String title;
    private String message;
    private Object picture;
    private String service;
    private Integer ratingDelivery;
    private Integer ratingQuality;
    private String url;

    public Last() {
    }

    public Boolean getAdvice() {
        return advice;
    }

    public void setAdvice(Boolean advice) {
        this.advice = advice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getRatingDelivery() {
        return ratingDelivery;
    }

    public void setRatingDelivery(Integer ratingDelivery) {
        this.ratingDelivery = ratingDelivery;
    }

    public Integer getRatingQuality() {
        return ratingQuality;
    }

    public void setRatingQuality(Integer ratingQuality) {
        this.ratingQuality = ratingQuality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

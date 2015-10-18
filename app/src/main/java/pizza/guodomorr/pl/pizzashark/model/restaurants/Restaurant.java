package pizza.guodomorr.pl.pizzashark.model.restaurants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 18.10.15.
 */
public class Restaurant {
    private Integer id;
    private String name;
    private String street;
    private String number;
    private String plz;
    private String telephone;
    private String email;
    private String locationName;
    private Integer locationId;
    private Integer stateId;
    private String state;
    private Integer status;
    private Integer isOnline;
    private Boolean isnew;
    private Integer paymentbar;
    private String preorder;
    private String url;
    private Integer onlycash;
    private Object specialComment;
    private String imageUrl;
    private Integer ratingCount;
    private Integer ratingAdviceCount;
    private Double ratingAverage;
    private String tags;
    private List<Opening> openings = new ArrayList<Opening>();
    private OpeningSpecial openingSpecial;
    private Object mealTypes;
    private String restaurantCategory;
    private Integer franchiseTypeId;
    private String franchiseType;
    private Object holidays;
    private Boolean sms;
    private Integer favouriteCount;
    private Double latitude;
    private Double longitude;
    private List<RestaurantPayment> restaurantPayments = new ArrayList<RestaurantPayment>();
    private Integer mincost;
    private Integer delivercost;
    private Object noDeliverCostAbove;
    private Integer preorderOffset;
    private Boolean toplisted;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", plz='" + plz + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationId=" + locationId +
                ", stateId=" + stateId +
                ", state='" + state + '\'' +
                ", status=" + status +
                ", isOnline=" + isOnline +
                ", isnew=" + isnew +
                ", paymentbar=" + paymentbar +
                ", preorder='" + preorder + '\'' +
                ", url='" + url + '\'' +
                ", onlycash=" + onlycash +
                ", specialComment=" + specialComment +
                ", imageUrl='" + imageUrl + '\'' +
                ", ratingCount=" + ratingCount +
                ", ratingAdviceCount=" + ratingAdviceCount +
                ", ratingAverage=" + ratingAverage +
                ", tags='" + tags + '\'' +
                ", openings=" + openings +
                ", openingSpecial=" + openingSpecial +
                ", mealTypes=" + mealTypes +
                ", restaurantCategory='" + restaurantCategory + '\'' +
                ", franchiseTypeId=" + franchiseTypeId +
                ", franchiseType='" + franchiseType + '\'' +
                ", holidays=" + holidays +
                ", sms=" + sms +
                ", favouriteCount=" + favouriteCount +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", restaurantPayments=" + restaurantPayments +
                ", mincost=" + mincost +
                ", delivercost=" + delivercost +
                ", noDeliverCostAbove=" + noDeliverCostAbove +
                ", preorderOffset=" + preorderOffset +
                ", toplisted=" + toplisted +
                '}';
    }

    public Restaurant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Boolean getIsnew() {
        return isnew;
    }

    public void setIsnew(Boolean isnew) {
        this.isnew = isnew;
    }

    public Integer getPaymentbar() {
        return paymentbar;
    }

    public void setPaymentbar(Integer paymentbar) {
        this.paymentbar = paymentbar;
    }

    public String getPreorder() {
        return preorder;
    }

    public void setPreorder(String preorder) {
        this.preorder = preorder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOnlycash() {
        return onlycash;
    }

    public void setOnlycash(Integer onlycash) {
        this.onlycash = onlycash;
    }

    public Object getSpecialComment() {
        return specialComment;
    }

    public void setSpecialComment(Object specialComment) {
        this.specialComment = specialComment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getRatingAdviceCount() {
        return ratingAdviceCount;
    }

    public void setRatingAdviceCount(Integer ratingAdviceCount) {
        this.ratingAdviceCount = ratingAdviceCount;
    }

    public Double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Opening> getOpenings() {
        return openings;
    }

    public void setOpenings(List<Opening> openings) {
        this.openings = openings;
    }

    public OpeningSpecial getOpeningSpecial() {
        return openingSpecial;
    }

    public void setOpeningSpecial(OpeningSpecial openingSpecial) {
        this.openingSpecial = openingSpecial;
    }

    public Object getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Object mealTypes) {
        this.mealTypes = mealTypes;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public Integer getFranchiseTypeId() {
        return franchiseTypeId;
    }

    public void setFranchiseTypeId(Integer franchiseTypeId) {
        this.franchiseTypeId = franchiseTypeId;
    }

    public String getFranchiseType() {
        return franchiseType;
    }

    public void setFranchiseType(String franchiseType) {
        this.franchiseType = franchiseType;
    }

    public Object getHolidays() {
        return holidays;
    }

    public void setHolidays(Object holidays) {
        this.holidays = holidays;
    }

    public Boolean getSms() {
        return sms;
    }

    public void setSms(Boolean sms) {
        this.sms = sms;
    }

    public Integer getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Integer favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<RestaurantPayment> getRestaurantPayments() {
        return restaurantPayments;
    }

    public void setRestaurantPayments(List<RestaurantPayment> restaurantPayments) {
        this.restaurantPayments = restaurantPayments;
    }

    public Integer getMincost() {
        return mincost;
    }

    public void setMincost(Integer mincost) {
        this.mincost = mincost;
    }

    public Integer getDelivercost() {
        return delivercost;
    }

    public void setDelivercost(Integer delivercost) {
        this.delivercost = delivercost;
    }

    public Object getNoDeliverCostAbove() {
        return noDeliverCostAbove;
    }

    public void setNoDeliverCostAbove(Object noDeliverCostAbove) {
        this.noDeliverCostAbove = noDeliverCostAbove;
    }

    public Integer getPreorderOffset() {
        return preorderOffset;
    }

    public void setPreorderOffset(Integer preorderOffset) {
        this.preorderOffset = preorderOffset;
    }

    public Boolean getToplisted() {
        return toplisted;
    }

    public void setToplisted(Boolean toplisted) {
        this.toplisted = toplisted;
    }
}

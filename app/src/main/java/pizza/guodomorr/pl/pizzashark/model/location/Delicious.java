package pizza.guodomorr.pl.pizzashark.model.location;

import android.media.Rating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 10.10.15.
 */
public class Delicious {
    private Integer cityId;
    private Integer stateId;
    private Integer regionId;
    private Integer districtId;
    private String state;
    private String plz;
    private String name;
    private String locationName;
    private String regionName;
    private String regionUrl;
    private String url;
    private Object seoHeadline;
    private Double latitude;
    private Double longitude;
    private List<RegionDistrict> regionPlz = new ArrayList<>();
    private List<RegionDistrict> regionDistrict = new ArrayList<>();
    private List<OtherRegion> otherRegion = new ArrayList<>();
    private Rating rating;

    public Delicious() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getSeoHeadline() {
        return seoHeadline;
    }

    public void setSeoHeadline(Object seoHeadline) {
        this.seoHeadline = seoHeadline;
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

    public List<RegionDistrict> getRegionPlz() {
        return regionPlz;
    }

    public void setRegionPlz(List<RegionDistrict> regionPlz) {
        this.regionPlz = regionPlz;
    }

    public List<RegionDistrict> getRegionDistrict() {
        return regionDistrict;
    }

    public void setRegionDistrict(List<RegionDistrict> regionDistrict) {
        this.regionDistrict = regionDistrict;
    }

    public List<OtherRegion> getOtherRegion() {
        return otherRegion;
    }

    public void setOtherRegion(List<OtherRegion> otherRegion) {
        this.otherRegion = otherRegion;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}

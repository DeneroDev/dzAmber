package com.example.denero.ambercard.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by DENERO on 11.10.2017.
 */

public class PagePOJO {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category_id")
    @Expose
    private List<CategoryId> categoryId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_2")
    @Expose
    private String description2;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("cost_sum")
    @Expose
    private String costSum;
    @SerializedName("cost_text")
    @Expose
    private String costText;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("discount_min")
    @Expose
    private String discountMin;
    @SerializedName("discount_max")
    @Expose
    private String discountMax;
    @SerializedName("discount_conditions")
    @Expose
    private String discountConditions;
    @SerializedName("min_people")
    @Expose
    private Object minPeople;
    @SerializedName("max_people")
    @Expose
    private Object maxPeople;
    @SerializedName("photos")
    @Expose
    private List<String> photos = null;

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

    public List<CategoryId> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<CategoryId> categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
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

    public String getRate() {
        return rate;
    }
    ///sadaszxcz

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCostSum() {
        return costSum;
    }

    public void setCostSum(String costSum) {
        this.costSum = costSum;
    }

    public String getCostText() {
        return costText;
    }

    public void setCostText(String costText) {
        this.costText = costText;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDiscountMin() {
        return discountMin;
    }

    public void setDiscountMin(String discountMin) {
        this.discountMin = discountMin;
    }

    public String getDiscountMax() {
        return discountMax;
    }

    public void setDiscountMax(String discountMax) {
        this.discountMax = discountMax;
    }

    public String getDiscountConditions() {
        return discountConditions;
    }

    public void setDiscountConditions(String discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Object getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(Object minPeople) {
        this.minPeople = minPeople;
    }

    public Object getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Object maxPeople) {
        this.maxPeople = maxPeople;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}

package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HogozatyResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("DirectSale_id")
    @Expose
    private Integer directSaleId;
    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("publisher_id")
    @Expose
    private Integer publisherId;
    @SerializedName("number_products")
    @Expose
    private String numberProducts;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("approved")
    @Expose
    private String approved;
    @SerializedName("time_publish")
    @Expose
    private String timePublish;
    @SerializedName("directsale")
    @Expose
    private Directsale directsale;
    @SerializedName("user")
    @Expose
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDirectSaleId() {
        return directSaleId;
    }

    public void setDirectSaleId(Integer directSaleId) {
        this.directSaleId = directSaleId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(String numberProducts) {
        this.numberProducts = numberProducts;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getTimePublish() {
        return timePublish;
    }

    public void setTimePublish(String timePublish) {
        this.timePublish = timePublish;
    }

    public Directsale getDirectsale() {
        return directsale;
    }

    public void setDirectsale(Directsale directsale) {
        this.directsale = directsale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

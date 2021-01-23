package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DirectAddResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("img1")
    @Expose
    private String img1;
    @SerializedName("img2")
    @Expose
    private Object img2;
    @SerializedName("img3")
    @Expose
    private Object img3;
    @SerializedName("band_rkm")
    @Expose
    private Integer bandRkm;
    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("available_number")
    @Expose
    private Integer availableNumber;
    @SerializedName("general_description")
    @Expose
    private String generalDescription;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("publisher_id")
    @Expose
    private Integer publisherId;
    @SerializedName("isbooked")
    @Expose
    private Integer isbooked;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("time_publish")
    @Expose
    private String timePublish;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("users")
    @Expose
    private User users;
    @SerializedName("DirectSale_id")
    @Expose
    private Integer directSaleId;

    public Integer getDirectSaleId() {
        return directSaleId;
    }

    public void setDirectSaleId(Integer directSaleId) {
        this.directSaleId = directSaleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public Object getImg2() {
        return img2;
    }

    public void setImg2(Object img2) {
        this.img2 = img2;
    }

    public Object getImg3() {
        return img3;
    }

    public void setImg3(Object img3) {
        this.img3 = img3;
    }

    public Integer getBandRkm() {
        return bandRkm;
    }

    public void setBandRkm(Integer bandRkm) {
        this.bandRkm = bandRkm;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Integer availableNumber) {
        this.availableNumber = availableNumber;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getIsbooked() {
        return isbooked;
    }

    public void setIsbooked(Integer isbooked) {
        this.isbooked = isbooked;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTimePublish() {
        return timePublish;
    }

    public void setTimePublish(String timePublish) {
        this.timePublish = timePublish;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

}
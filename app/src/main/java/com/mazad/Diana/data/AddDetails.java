package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddDetails  {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("img1")
    @Expose
    private String img1;
    @SerializedName("img2")
    @Expose
    private String img2;
    @SerializedName("img3")
    @Expose
    private String img3;
    @SerializedName("band_rkm")
    @Expose
    private Integer bandRkm;
    @SerializedName("general_description")
    @Expose
    private String generalDescription;
    @SerializedName("maindropdownlist")
    @Expose
    private String maindropdownlist;
    @SerializedName("subdropdownlist")
    @Expose
    private String subdropdownlist;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("available_number")
    @Expose
    private Integer availableNumber;
    @SerializedName("publisher_id")
    @Expose
    private Integer publisherId;
    @SerializedName("isbooked")
    @Expose
    private Integer isbooked;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("dropdownlistids")
    @Expose
    private List<Dropdownlistid> dropdownlistids = null;
    @SerializedName("users")
    @Expose
    private User users;
    @SerializedName("time_publish")
    @Expose
    private String timePublish;

    public String getTimePublish() {
        return timePublish;
    }

    public void setTimePublish(String timePublish) {
        this.timePublish = timePublish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public Integer getBandRkm() {
        return bandRkm;
    }

    public void setBandRkm(Integer bandRkm) {
        this.bandRkm = bandRkm;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getMaindropdownlist() {
        return maindropdownlist;
    }

    public void setMaindropdownlist(String maindropdownlist) {
        this.maindropdownlist = maindropdownlist;
    }

    public String getSubdropdownlist() {
        return subdropdownlist;
    }

    public void setSubdropdownlist(String subdropdownlist) {
        this.subdropdownlist = subdropdownlist;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Integer availableNumber) {
        this.availableNumber = availableNumber;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Dropdownlistid> getDropdownlistids() {
        return dropdownlistids;
    }

    public void setDropdownlistids(List<Dropdownlistid> dropdownlistids) {
        this.dropdownlistids = dropdownlistids;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}

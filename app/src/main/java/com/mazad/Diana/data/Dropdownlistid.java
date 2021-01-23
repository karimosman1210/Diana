package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dropdownlistid {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mainTitle_id")
    @Expose
    private Integer mainTitleId;
    @SerializedName("DirectSale_id")
    @Expose
    private Integer directSaleId;
    @SerializedName("subTitle_id")
    @Expose
    private Integer subTitleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("main_title")
    @Expose
    private MainTitle mainTitle;
    @SerializedName("sub_title")
    @Expose
    private SubTitle subTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainTitleId() {
        return mainTitleId;
    }

    public void setMainTitleId(Integer mainTitleId) {
        this.mainTitleId = mainTitleId;
    }

    public Integer getDirectSaleId() {
        return directSaleId;
    }

    public void setDirectSaleId(Integer directSaleId) {
        this.directSaleId = directSaleId;
    }

    public Integer getSubTitleId() {
        return subTitleId;
    }

    public void setSubTitleId(Integer subTitleId) {
        this.subTitleId = subTitleId;
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

    public MainTitle getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(MainTitle mainTitle) {
        this.mainTitle = mainTitle;
    }

    public SubTitle getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(SubTitle subTitle) {
        this.subTitle = subTitle;
    }

}

package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainTitle {

    @SerializedName("cate_id")
    @Expose
    private Integer cateId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ismandatory")
    @Expose
    private Integer ismandatory;
    @SerializedName("mainTitle")
    @Expose
    private String mainTitle;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Integer ismandatory) {
        this.ismandatory = ismandatory;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }
}

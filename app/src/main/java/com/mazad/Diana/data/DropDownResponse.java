package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DropDownResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mainTitle")
    @Expose
    private String mainTitle;
    @SerializedName("ismandatory")
    @Expose
    private Integer ismandatory;
    @SerializedName("sub_titles")
    @Expose
    private List<SubTitleDropDown> subTitles = null;

    public int idChecked;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public Integer getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Integer ismandatory) {
        this.ismandatory = ismandatory;
    }

    public List<SubTitleDropDown> getSubTitles() {
        return subTitles;
    }

    public void setSubTitles(List<SubTitleDropDown> subTitles) {
        this.subTitles = subTitles;
    }

}

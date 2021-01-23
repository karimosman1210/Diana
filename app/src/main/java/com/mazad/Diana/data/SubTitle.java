package com.mazad.Diana.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTitle {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mainTitle_id")
    @Expose
    private String mainTitleId;
    @SerializedName("title")
    @Expose
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainTitleId() {
        return mainTitleId;
    }

    public void setMainTitleId(String mainTitleId) {
        this.mainTitleId = mainTitleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

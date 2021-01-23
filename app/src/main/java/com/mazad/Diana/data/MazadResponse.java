package com.mazad.Diana.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MazadResponse implements Parcelable {
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
    @SerializedName("new_price")
    @Expose
    private Integer newPrice;
    @SerializedName("add_time_state")
    @Expose
    private Integer addTimeState;
    @SerializedName("end_add_time")
    @Expose
    private Integer endAddTime;
    @SerializedName("require_price_startdate")
    @Expose
    private String requirePriceStartdate;
    @SerializedName("require_price_enddate")
    @Expose
    private String requirePriceEnddate;
    @SerializedName("right_back")
    @Expose
    private Integer rightBack;
    @SerializedName("raise")
    @Expose
    private Integer raise;
    @SerializedName("raise_rkm")
    @Expose
    private Integer raiseRkm;
    @SerializedName("less_raise")
    @Expose
    private Integer lessRaise;
    @SerializedName("enter_mazad")
    @Expose
    private Integer enterMazad;
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
    @SerializedName("mazad_end_date")
    @Expose
    private String mazadEndDate;
    @SerializedName("mazad_finished")
    @Expose
    private Integer mazadFinished;
    @SerializedName("time_publish")
    @Expose
    private String timePublish;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("users")
    @Expose
    private User users;
    @SerializedName("dropdownlistids")
    @Expose
    private List<Dropdownlistid> dropdownlistids = null;

    public List<Dropdownlistid> getDropdownlistids() {
        return dropdownlistids;
    }

    public void setDropdownlistids(List<Dropdownlistid> dropdownlistids) {
        this.dropdownlistids = dropdownlistids;
    }
    protected MazadResponse(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            cateId = null;
        } else {
            cateId = in.readInt();
        }
        img1 = in.readString();
        if (in.readByte() == 0) {
            bandRkm = null;
        } else {
            bandRkm = in.readInt();
        }
        generalDescription = in.readString();
        maindropdownlist = in.readString();
        subdropdownlist = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        if (in.readByte() == 0) {
            newPrice = null;
        } else {
            newPrice = in.readInt();
        }
        if (in.readByte() == 0) {
            addTimeState = null;
        } else {
            addTimeState = in.readInt();
        }
        if (in.readByte() == 0) {
            endAddTime = null;
        } else {
            endAddTime = in.readInt();
        }
        requirePriceStartdate = in.readString();
        requirePriceEnddate = in.readString();
        if (in.readByte() == 0) {
            rightBack = null;
        } else {
            rightBack = in.readInt();
        }
        if (in.readByte() == 0) {
            raise = null;
        } else {
            raise = in.readInt();
        }
        if (in.readByte() == 0) {
            raiseRkm = null;
        } else {
            raiseRkm = in.readInt();
        }
        if (in.readByte() == 0) {
            lessRaise = null;
        } else {
            lessRaise = in.readInt();
        }
        if (in.readByte() == 0) {
            enterMazad = null;
        } else {
            enterMazad = in.readInt();
        }
        if (in.readByte() == 0) {
            publisherId = null;
        } else {
            publisherId = in.readInt();
        }
        if (in.readByte() == 0) {
            isbooked = null;
        } else {
            isbooked = in.readInt();
        }
        createdAt = in.readString();
        updatedAt = in.readString();
        mazadEndDate = in.readString();
        if (in.readByte() == 0) {
            mazadFinished = null;
        } else {
            mazadFinished = in.readInt();
        }
        timePublish = in.readString();
        imagePath = in.readString();
        users = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (cateId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cateId);
        }
        dest.writeString(img1);
        if (bandRkm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(bandRkm);
        }
        dest.writeString(generalDescription);
        dest.writeString(maindropdownlist);
        dest.writeString(subdropdownlist);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(price);
        }
        if (newPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(newPrice);
        }
        if (addTimeState == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(addTimeState);
        }
        if (endAddTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(endAddTime);
        }
        dest.writeString(requirePriceStartdate);
        dest.writeString(requirePriceEnddate);
        if (rightBack == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(rightBack);
        }
        if (raise == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(raise);
        }
        if (raiseRkm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(raiseRkm);
        }
        if (lessRaise == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lessRaise);
        }
        if (enterMazad == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(enterMazad);
        }
        if (publisherId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(publisherId);
        }
        if (isbooked == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isbooked);
        }
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(mazadEndDate);
        if (mazadFinished == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mazadFinished);
        }
        dest.writeString(timePublish);
        dest.writeString(imagePath);
        dest.writeParcelable(users, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MazadResponse> CREATOR = new Creator<MazadResponse>() {
        @Override
        public MazadResponse createFromParcel(Parcel in) {
            return new MazadResponse(in);
        }

        @Override
        public MazadResponse[] newArray(int size) {
            return new MazadResponse[size];
        }
    };

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

    public Object getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public Object getImg3() {
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

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getAddTimeState() {
        return addTimeState;
    }

    public void setAddTimeState(Integer addTimeState) {
        this.addTimeState = addTimeState;
    }

    public Integer getEndAddTime() {
        return endAddTime;
    }

    public void setEndAddTime(Integer endAddTime) {
        this.endAddTime = endAddTime;
    }

    public String getRequirePriceStartdate() {
        return requirePriceStartdate;
    }

    public void setRequirePriceStartdate(String requirePriceStartdate) {
        this.requirePriceStartdate = requirePriceStartdate;
    }

    public String getRequirePriceEnddate() {
        return requirePriceEnddate;
    }

    public void setRequirePriceEnddate(String requirePriceEnddate) {
        this.requirePriceEnddate = requirePriceEnddate;
    }

    public Integer getRightBack() {
        return rightBack;
    }

    public void setRightBack(Integer rightBack) {
        this.rightBack = rightBack;
    }

    public Integer getRaise() {
        return raise;
    }

    public void setRaise(Integer raise) {
        this.raise = raise;
    }

    public Integer getRaiseRkm() {
        return raiseRkm;
    }

    public void setRaiseRkm(Integer raiseRkm) {
        this.raiseRkm = raiseRkm;
    }

    public Integer getLessRaise() {
        return lessRaise;
    }

    public void setLessRaise(Integer lessRaise) {
        this.lessRaise = lessRaise;
    }

    public Integer getEnterMazad() {
        return enterMazad;
    }

    public void setEnterMazad(Integer enterMazad) {
        this.enterMazad = enterMazad;
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

    public String getMazadEndDate() {
        return mazadEndDate;
    }

    public void setMazadEndDate(String mazadEndDate) {
        this.mazadEndDate = mazadEndDate;
    }

    public Integer getMazadFinished() {
        return mazadFinished;
    }

    public void setMazadFinished(Integer mazadFinished) {
        this.mazadFinished = mazadFinished;
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

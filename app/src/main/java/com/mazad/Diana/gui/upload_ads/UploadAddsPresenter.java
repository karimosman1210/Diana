package com.mazad.Diana.gui.upload_ads;

import android.content.Context;
import android.util.Log;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.ImageResponse;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.DropDownResponse;
import com.mazad.Diana.data.MultPartPostDirectSale;
import com.mazad.Diana.data.MultPartSignUp;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainApiBody;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.mazad.Diana.data.network.MainApiBody.JSON_TYPE;

public class UploadAddsPresenter extends BasePresenter<UploadAddsView> {
    public void dropList(Context context, int catId) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.getDropDownApi(catId, new ConnectionListener<MainResponse<List<DropDownResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<DropDownResponse>>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.dorpDown(connectionResponse.data.data);
                    }
                }
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideloadingviewBase();
                view.showErrorMessageBase(context, context.getString(R.string.tryagaing));
            }
        });

    }


    void PostDirectSale(int categoryId, Context context, String band_rakam, String general_description, String listkey, String listValue, String price, File image1, File image2, File image3,Integer publisherId, String available_number) {

        if (Validator.isTextEmpty(band_rakam)) {
            view.showErrorMessageBase(context, context.getString(R.string.band_rakam));
            return;
        } else if (Validator.isTextEmpty(general_description)) {
            view.showErrorMessageBase(context, context.getString(R.string.desception));
            return;
        } else if (Validator.isTextEmpty(price)) {
            view.showErrorMessageBase(context, context.getString(R.string.price));
            return;
        }

        sendPostDirectSale(String.valueOf(categoryId), context, band_rakam, general_description, listkey, listValue, price, image1, image2, image3, String.valueOf(publisherId), available_number);

    }

    private void sendPostDirectSale(String categoryId, Context mContext, String band_rakam, String general_description,
                                    String listKey, String listValue, String price, File image1, File image2, File image3, String publisher_id, String available_number) {
        MultPartPostDirectSale multPartPostDirectSale = null;
        multPartPostDirectSale = MainApiBody.PostDirctBody(categoryId, band_rakam, general_description, price, publisher_id, available_number, listKey, listValue);
        MultipartBody.Part im1 = null;
        MultipartBody.Part im2 = null;
        MultipartBody.Part im3 = null;
        if (image1 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image1);
            im1 = MultipartBody.Part.createFormData("img1", image1.getName(), reqFile);
        }

        if (image2 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image2);
            im2 = MultipartBody.Part.createFormData("img2", image2.getName(), reqFile);
        }
        if (image3 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image3);
            im3 = MultipartBody.Part.createFormData("img3", image3.getName(), reqFile);
        }
        view.showloadingviewBase(mContext);
        MainApi.directSalePost(im1, im2, im3, multPartPostDirectSale.cat_id, multPartPostDirectSale.band_rkm, multPartPostDirectSale.general_description, multPartPostDirectSale.values,
                multPartPostDirectSale.keys, multPartPostDirectSale.price, multPartPostDirectSale.pusherRequst, multPartPostDirectSale.available_numberRequest, new ConnectionListener<MainResponse<StatusResponse>>() {
                    @Override
                    public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                        view.hideloadingviewBase();
                        StaticMethods.printJson("connectionResponse",connectionResponse);
                        if (connectionResponse.data.data != null) {
                            if (connectionResponse.data.success){
                                view.successAdded();
                                view.showSuccessMessageBase(mContext,connectionResponse.data.message);
                            }else {
                                view.showErrorMessageBase(mContext,connectionResponse.data.message);

                            }
                        }
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        view.hideloadingviewBase();
                        StaticMethods.printJson("saddasd", throwable.getMessage());
                        view.showErrorMessageBase(mContext, mContext.getString(R.string.tryagaing));
                    }
                });

    }


}

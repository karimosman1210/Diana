package com.mazad.Diana.gui.upload_mazad;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.DropDownResponse;

import java.util.List;

public interface UploadMazadView extends BaseView {
    void dorpDown(List<DropDownResponse> data);

    void successAdded();
}

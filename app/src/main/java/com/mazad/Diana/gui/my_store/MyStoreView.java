package com.mazad.Diana.gui.my_store;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.DirectAddResponse;

import java.util.List;

public interface MyStoreView extends BaseView {
    void storeList(List<DirectAddResponse> data);

    void rebublishSuccess();
}

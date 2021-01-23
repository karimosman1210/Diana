package com.mazad.Diana.gui.hogozaty;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.HogozatyResponse;

import java.util.List;

public interface HogozatyView extends BaseView {
    void currentAddDetails(List<HogozatyResponse> data);
}

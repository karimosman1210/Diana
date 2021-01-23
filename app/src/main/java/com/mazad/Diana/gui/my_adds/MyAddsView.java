package com.mazad.Diana.gui.my_adds;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.AddDetails;

import java.util.List;

public interface MyAddsView extends BaseView {
    void currentAddDetails(List<AddDetails> data);
}

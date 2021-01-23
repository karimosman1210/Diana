package com.mazad.Diana.gui.display_mazadat;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.MazadResponse;

import java.util.List;

public interface DisplayMazadatView extends BaseView {

    void MazadPostsList(List<MazadResponse> data);
}

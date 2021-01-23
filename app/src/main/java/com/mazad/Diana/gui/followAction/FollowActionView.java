package com.mazad.Diana.gui.followAction;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.FollowMazadResponse;
import com.mazad.Diana.data.HogozatyResponse;

import java.util.List;

public interface FollowActionView extends BaseView {


    void userEnterList(List<FollowMazadResponse> data);
}

package com.mazad.Diana.gui.list_direct_adds;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.UserResponse;

import java.util.List;

public interface ListDirectAddsView extends BaseView {
    void DirectPostsList(List<DirectAddResponse> data);
}

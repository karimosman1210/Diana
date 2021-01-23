package com.mazad.Diana.gui.category;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.CategoriesResponse;

import java.util.List;

public interface CategoryView extends BaseView {
    void categoryList(List<CategoriesResponse> responseList);
}

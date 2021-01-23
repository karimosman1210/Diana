package com.mazad.Diana.gui.sale_type;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.Sale_typeResponse;

import java.util.List;

public interface Sale_typeView extends BaseView {
    void listMazad(List<Sale_typeResponse> mazadList);
    void listDirect (List<Sale_typeResponse> DirectList);

}

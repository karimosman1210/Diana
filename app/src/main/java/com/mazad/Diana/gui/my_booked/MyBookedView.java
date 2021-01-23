package com.mazad.Diana.gui.my_booked;

import com.mazad.Diana.base_class.BaseView;
import com.mazad.Diana.data.BookListResponse;

import java.util.List;

public interface MyBookedView extends BaseView {
    void listUserBooked(List<BookListResponse> data);
    void acceptBookedSuccess();
}

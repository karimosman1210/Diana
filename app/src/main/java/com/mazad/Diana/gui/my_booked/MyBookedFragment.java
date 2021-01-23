package com.mazad.Diana.gui.my_booked;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.MyBookListAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.BookListResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyBookedFragment extends BaseFragment implements MyBookedView, MyBookListAdapter.ConfermInterface {
    MyBookedPresenter presenter;
    MyBookListAdapter adapter;
    @BindView(R.id.bookedListRv)
    RecyclerView bookedListRv;
    public static int addIdRefrance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_booked, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        bookedListRv.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter = new MyBookedPresenter();
        presenter.attachView(this);
        presenter.getMyAddsData(addIdRefrance, getContext());
    }

    @Override
    public void listUserBooked(List<BookListResponse> data) {
        adapter = new MyBookListAdapter(data, getContext(), this);
        bookedListRv.setAdapter(adapter);
    }


    @Override
    public void clickConfermBook(BookListResponse booked) {
        presenter.acceptBookedData(booked.getDirectSaleId(), booked.getUser().getId(), getContext());
    }

    @Override
    public void acceptBookedSuccess() {
        initView();
    }

}
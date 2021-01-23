package com.mazad.Diana.gui.sale_type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.TypeSaleAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.DummyData;
import com.mazad.Diana.utels.StaticMethod;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mazad.Diana.utels.AppConstant.directList;
import static com.mazad.Diana.utels.AppConstant.mazadatList;


public class SaleTypeFragment extends BaseFragment   {
    @BindView(R.id.mazadRecycler)
    RecyclerView mazadRecycler ;
    TypeSaleAdapter adapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sale_type, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mazadRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new TypeSaleAdapter(getContext(),DummyData.getListType());
        mazadRecycler.setAdapter(adapter);

    }


}

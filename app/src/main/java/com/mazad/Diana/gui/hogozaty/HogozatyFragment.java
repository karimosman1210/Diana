package com.mazad.Diana.gui.hogozaty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.HogozatyAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.HogozatyResponse;
import com.mazad.Diana.utels.AppConstant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HogozatyFragment extends BaseFragment implements HogozatyView {
    @BindView(R.id.recyclerDirectAdds)
    RecyclerView recyclerDirectAdds;
    HogozatyPresenter presenter;
    HogozatyAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_hogozaty, container, false);
        ButterKnife.bind(this,view);
        initVribles();
        return view;
    }

    private void initVribles() {
        recyclerDirectAdds.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter=new HogozatyPresenter();
        presenter.attachView(this);
        presenter.addDetails(AppConstant.userResponse.getUser().get(0).getId(),getContext());
    }

    @Override
    public void currentAddDetails(List<HogozatyResponse> data) {
        adapter=new HogozatyAdapter(getContext(),data);
        recyclerDirectAdds.setAdapter(adapter);
    }
}
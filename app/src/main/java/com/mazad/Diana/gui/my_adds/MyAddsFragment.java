package com.mazad.Diana.gui.my_adds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.MyAddsAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.utels.AppConstant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyAddsFragment extends BaseFragment implements MyAddsView {
    MyAddsPresenter presenter ;
    MyAddsAdapter adapter;
    @BindView(R.id.recyclerDirectAdds)
    RecyclerView recyclerDirectAdds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_adds, container, false);
        ButterKnife.bind(this,view);

        initVribles();
        return view;
    }

    private void initVribles() {
        presenter=new MyAddsPresenter();
        presenter.attachView(this);
        presenter.addDetails(AppConstant.userResponse.getUser().get(0).getId(),getContext());
    }

    @Override
    public void currentAddDetails(List<AddDetails> data) {
        adapter=new MyAddsAdapter(getContext(),data);
        recyclerDirectAdds.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerDirectAdds.setAdapter(adapter);

    }
}
package com.mazad.Diana.gui.display_mazadat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.AdsAdapter;
import com.mazad.Diana.adapter.AdsRecycleAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.MazadResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DisplayMazadatFragment extends BaseFragment implements DisplayMazadatView {
    AdsAdapter adapter ;
    DisplayMazadatPresenter presenter;
    @BindView(R.id.recyclerMazadAdds)
    RecyclerView recyclerMazadAdds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_mazadat, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {

        ((HomeActivity)getContext()).showHideBottonBar(View.VISIBLE);
        recyclerMazadAdds.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter=new DisplayMazadatPresenter();
        presenter.attachView(this);
        presenter.directAdds(getContext(), AppConstant.saleTypeId,AppConstant.catId);
    }


    @Override
    public void MazadPostsList(List<MazadResponse> data) {
        StaticMethods.printJson("directAddsList",data);
        adapter=new AdsAdapter(getContext(),data);
        recyclerMazadAdds.setAdapter(adapter);

    }
}
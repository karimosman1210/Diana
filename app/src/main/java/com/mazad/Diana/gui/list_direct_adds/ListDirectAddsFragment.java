package com.mazad.Diana.gui.list_direct_adds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.AllAddsPostAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListDirectAddsFragment extends BaseFragment implements ListDirectAddsView {
    ListDirectAddsPresenter presenter ;
    AllAddsPostAdapter adapter ;
    @BindView(R.id.recyclerDirectAdds)
    RecyclerView recyclerDirectAdds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_direct_adds, container, false);
        ButterKnife.bind(this,view);
        initVaribles();
        return view;
    }

    private void initVaribles() {
        ((HomeActivity)getContext()).showHideBottonBar(View.VISIBLE);
        recyclerDirectAdds.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter =new ListDirectAddsPresenter();
        presenter.attachView(this);
        presenter.directAdds(getContext(), AppConstant.saleTypeId,AppConstant.catId);
    }

    @Override
    public void DirectPostsList(List<DirectAddResponse> data) {
        StaticMethods.printJson("directAddsList",data);
        adapter=new AllAddsPostAdapter(getContext(),data);
        recyclerDirectAdds.setAdapter(adapter);
    }
}
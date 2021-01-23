package com.mazad.Diana.gui.my_store;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mazad.Diana.R;
import com.mazad.Diana.adapter.MyStoreAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.dialogData.DialogPoP;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.gui.main_page.MainPage;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStoreFragment extends BaseFragment implements MyStoreView, MyStoreAdapter.clickView {
    MyStorePresenter presenter ;
    MyStoreAdapter adapter ;
    @BindView(R.id.recyclerDirectAdds)
    RecyclerView recyclerDirectAdds;
    int addId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_store, container, false);
        ButterKnife.bind(this,view);
        initVaribles();
        return view;
    }
    private void initVaribles() {
        ((HomeActivity)getContext()).showHideBottonBar(View.VISIBLE);
        recyclerDirectAdds.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter =new MyStorePresenter();
        presenter.attachView(this);
        presenter.storeAdd(getContext(), AppConstant.userResponse.getUser().get(0).getId());
    }

    @Override
    public void storeList(List<DirectAddResponse> data) {
        StaticMethods.printJson("directAddsList",data);
        adapter=new MyStoreAdapter(getContext(),data,this);
        recyclerDirectAdds.setAdapter(adapter);
    }

    @Override
    public void rebublishSuccess() {
        ((HomeActivity)getContext()).display(AppConstant.LIST_DIRECT_ADD_FRAGMENT);
    }

    @Override
    public void republishAdd(Integer id) {
        addId=id;
        ShowDialog();
    }

    public void ShowDialog() {
        View view = getLayoutInflater().inflate(R.layout.button_sheet, null);
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(view);
        dialog.show();
        Button cashBtn = view.findViewById(R.id.confermBtn);
        Button visaBtn = view.findViewById(R.id.cancel);
        EditText price = view.findViewById(R.id.priceEtSheet);

        cashBtn.setOnClickListener(v -> {

            presenter.rePublishAdd(addId,price.getText().toString(),getContext());
             dialog.hide();
        });

        visaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.hide();



            }

        });

    }

}
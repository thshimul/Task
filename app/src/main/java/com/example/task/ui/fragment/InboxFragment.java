package com.example.task.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.MainPresenter;
import com.example.task.Model.DataModel;
import com.example.task.R;
import com.example.task.adapter.Myadapter;

import java.util.ArrayList;
import java.util.List;


public class InboxFragment extends Fragment {
    private static final String TAG = "InboxFragment";
     View v;
     private RecyclerView recyclerView;
     private List<DataModel> istname;
    Myadapter myadapter = null;
    MainPresenter presenter = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_inbox, container, false);
        recyclerView=v.findViewById(R.id.inboxrecyler);
        myadapter=new Myadapter(getContext(),istname);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myadapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(getActivity(), new MainPresenter.MainListener() {
            @Override
            public void onSuccess(List<DataModel> dataModel) {
                Log.d(TAG, "onSuccess: "+dataModel.get(0).getTitle());
                myadapter.setData(dataModel);
            }

            @Override
            public void onError() {
                Log.d(TAG, "onError: Something went wrong");
            }
        });
        presenter.getApiData();
        istname=new ArrayList<>();
//        istname.add(new DataModel("shimul","kaunia"));
//        istname.add(new DataModel("hasan","kaunia"));
//        istname.add(new DataModel("th","kaunia"));
//        istname.add(new DataModel("sm","kaunia"));
//        istname.add(new DataModel("smth","kaunia"));
//        istname.add(new DataModel("ths","kaunia"));
//        istname.add(new DataModel("smths","kaunia"));
    }
}

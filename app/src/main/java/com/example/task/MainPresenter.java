package com.example.task;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.task.Model.DataModel;
import com.example.task.Network.ApiService;
import com.example.task.Network.RetrofitClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    Context mContext = null;
    MainListener mainListener;
    private static final String TAG = "MainPresenter";
    public MainPresenter(Context context, MainListener listener) {
        mContext = context;
        mainListener = listener;
    }

    public void getApiData() {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        apiService.listRepos().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.isSuccessful()) {
//                    String responseString = null;
//                    try {
//                        responseString = response.body().string();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    Gson gson = new Gson();
//                    DataModel dataModel = gson.fromJson(responseString, DataModel.class);
                    List<DataModel> dataModelList = response.body();
                    mainListener.onSuccess(dataModelList);
                    Log.d(TAG, "response is successfull"+dataModelList.get(0).getTitle());
                } else {
                    mainListener.onError();
                    Log.d(TAG, "response with error");
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: something went wrong");
            }

        });
    }

    public interface MainListener {
        void onSuccess(List<DataModel> dataModel);

        void onError();
    }
}

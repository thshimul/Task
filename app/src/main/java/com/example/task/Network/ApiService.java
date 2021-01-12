package com.example.task.Network;
import com.example.task.Model.DataModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/todos/")
    Call<List<DataModel>> listRepos();
}

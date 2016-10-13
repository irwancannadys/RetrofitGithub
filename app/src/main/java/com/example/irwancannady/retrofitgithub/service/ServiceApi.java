package com.example.irwancannady.retrofitgithub.service;

import com.example.irwancannady.retrofitgithub.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by irwancannady on 10/13/16.
 */

public interface ServiceApi {


    @GET("users/irwancannadys")
    Call<Model> getModel();
}

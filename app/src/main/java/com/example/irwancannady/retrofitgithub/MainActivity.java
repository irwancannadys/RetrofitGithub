package com.example.irwancannady.retrofitgithub;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.irwancannady.retrofitgithub.service.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Model model;
    public static final String BASE_URL = "https://api.github.com/";
    private TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);


        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Mohon Tunggu","Memuat data anda....", false, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi api = retrofit.create(ServiceApi.class);
        Call<Model> call = api.getModel();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                progressDialog.dismiss();

                model = response.body();
                textView1.setText(getString(R.string.hello) + model.getName() + " Welcome to github");
                textView2.setText(getString(R.string.company) + model.getCompany() + "");
                textView3.setText(getString(R.string.repost) + model.getPublic_repos() + "");

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

    }
}

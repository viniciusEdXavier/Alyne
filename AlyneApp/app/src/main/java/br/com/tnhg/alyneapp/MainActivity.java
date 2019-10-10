package br.com.tnhg.alyneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.INTERNET)},1 );
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.ACCESS_NETWORK_STATE)},2 );
        }
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.20.23.23:3001/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void login(View view) {
        EditText userEdt = findViewById(R.id.edtUsuario);
        EditText passEdt = findViewById(R.id.edtSenha);
        final MainActivity mainActivity = this;
        String user = userEdt.getText().toString();
        String pass = passEdt.getText().toString();
        EndpointInterface api = retrofit.create(EndpointInterface.class);
        api.getResponse().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.d("tag", "DEUBOM");
                Toast.makeText(mainActivity, response.body().getSucesso(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("tag", "FALHA CATASTRÓFICA");
                Log.d("tag", t.getMessage());
            }
        });
    }
}

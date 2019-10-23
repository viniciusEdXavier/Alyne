package br.com.tnhg.alyneapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventFormActivity extends AppCompatActivity {

    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_event);
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.56.1:3001/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
    }

    public void submit(View view) {
        Intent myIntent = new Intent(EventFormActivity.this, MainActivity.class);
        startActivity(myIntent);
        finish();
//        myIntent.putExtra("key", value); //Optional parameters
//
//        EditText nomeEdt = findViewById(R.id.edtEventoNome);
//        EditText localEdt = findViewById(R.id.edtEventoLocal);
//        final EventFormActivity mainActivity = this;
//        String nome = nomeEdt.getText().toString();
//        String local = localEdt.getText().toString();
//        NewEvent newEvent = new NewEvent();
//        newEvent.setNome(nome);
//        newEvent.setLocal(local);
//
//        EndpointInterface api = retrofit.create(EndpointInterface.class);
//        api.setEvento(newEvent).enqueue(new Callback<Void>(){
//            @Override
//            public void onResponse(Call <Void> call, retrofit2.Response<Void> response) {
//                try {
//                    Log.d("tag", "DEUBOM");
//                    if(response.isSuccessful())
//                        Toast.makeText(mainActivity, response.body().toString(), Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(mainActivity, "null", Toast.LENGTH_SHORT).show();
//                    Intent myIntent = new Intent(mainActivity, MainActivity.class);
//                    startActivity(myIntent);
//                    finish();
//                }
//                catch (Exception e){
//                    Log.e("tag", e.getMessage());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Log.d("tag", "FALHA CATASTRÓFICA");
//                Log.d("tag", t.getMessage());
//            }
//        });
//        api.getAuth(new Auth(user, pass)).enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                try {
//                    Log.d("tag", "DEUBOM");
//                    if(response.isSuccessful())
//                        Toast.makeText(mainActivity, response.body().toString(), Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(mainActivity, "null", Toast.LENGTH_SHORT).show();
//                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(myIntent);
//                    finish();
//                }
//                catch (Exception e){
//                    Log.e("tag", e.getMessage());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//                Log.d("tag", "FALHA CATASTRÓFICA");
//                Log.d("tag", t.getMessage());
//            }
//        });
    }
}

package br.com.tnhg.alyneapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;

public class EventFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_event);
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.56.1:3001/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
    }

    public void submitEvent(View view) {

//        finish();
//        myIntent.putExtra("key", value); //Optional parameters
//
        EditText nomeEdt = findViewById(R.id.edtEventoNome);
        EditText localEdt = findViewById(R.id.edtEventoLocal);
        final EventFormActivity mainActivity = this;
        String nome = nomeEdt.getText().toString();
        String local = localEdt.getText().toString();
        NewEvent newEvent = new NewEvent();
        newEvent.setName(nome);
        newEvent.setLocation(local);

        EndpointInterface api = RetrofitClass.retrofit.create(EndpointInterface.class);
        api.setEvento(newEvent, "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwibmFtZSI6IllvaGFuYSIsImVtYWlsIjoieW9oYW5hQGdtYWlsLmNvbSJ9.DgBzlW6gBNIHJqhS3VKXqPJRF85hUW3XtO2IAVkbBgk").enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call <Void> call, retrofit2.Response<Void> response) {
                try {
                    Intent myIntent = new Intent(EventFormActivity.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                catch (Exception e){
                    Log.e("tag", e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("tag", "FALHA CATASTRÓFICA");
                Log.d("tag", t.getMessage());
            }
        });
//        api.getAuth(new Auth(user, pass)).enqueue(new Callback<WSResponse>() {
//            @Override
//            public void onResponse(Call<WSResponse> call, retrofit2.WSResponse<WSResponse> response) {
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
//            public void onFailure(Call<WSResponse> call, Throwable t) {
//                Log.d("tag", "FALHA CATASTRÓFICA");
//                Log.d("tag", t.getMessage());
//            }
//        });
    }
}

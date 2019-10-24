package br.com.tnhg.alyneapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.tnhg.alyneapp.retrofit.EndpointInterface;
import br.com.tnhg.alyneapp.R;
import br.com.tnhg.alyneapp.retrofit.RetrofitClass;
import br.com.tnhg.alyneapp.wsentity.NewEvent;
import retrofit2.Call;
import retrofit2.Callback;

public class EventFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_event);
    }

    public void submitEvent(View view) {

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
    }
}

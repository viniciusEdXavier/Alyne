package br.com.tnhg.alyneapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.tnhg.alyneapp.retrofit.EndpointInterface;
import br.com.tnhg.alyneapp.R;
import br.com.tnhg.alyneapp.retrofit.RetrofitClass;
import br.com.tnhg.alyneapp.wsentity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserFormActivity extends AppCompatActivity {

    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_user);
    }

    public void submit(View view) {
        EditText nomeEdt = findViewById(R.id.edtUsuarioNome);
        EditText emailEdt = findViewById(R.id.edtUsuarioEmail);
        EditText senhaEdt = findViewById(R.id.edtUsuarioSenha);
        final UserFormActivity mainActivity = this;
        String nome = nomeEdt.getText().toString();
        String email = emailEdt.getText().toString();
        String senha = senhaEdt.getText().toString();
        User user = new User();
        user.setName(nome);
        user.setEmail(email);
        user.setPassword(senha);
        EndpointInterface api = RetrofitClass.retrofit.create(EndpointInterface.class);
        api.setUser(user).enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    Log.d("tag", "DEUBOM");
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

package br.com.tnhg.alyneapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
//        Intent myIntent = new Intent(UserFormActivity.this, LoginActivity.class);
//        startActivity(myIntent);
//        finish();
//        myIntent.putExtra("key", value); //Optional parameters
//
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
//
        EndpointInterface api = RetrofitClass.retrofit.create(EndpointInterface.class);
        api.setUser(user).enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    Log.d("tag", "DEUBOM");
                    if(response.isSuccessful())
                        Log.d("tag", "foi");
                    else
                        Log.d("tag", "naofoi");
//                    Intent myIntent = new Intent(mainActivity, MainActivity.class);
//                    startActivity(myIntent);
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

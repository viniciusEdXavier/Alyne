package br.com.tnhg.alyneapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.com.tnhg.alyneapp.retrofit.EndpointInterface;
import br.com.tnhg.alyneapp.R;
import br.com.tnhg.alyneapp.retrofit.RetrofitClass;
import br.com.tnhg.alyneapp.wsentity.Auth;
import br.com.tnhg.alyneapp.wsentity.WSResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getPreferences(MODE_PRIVATE);
        setContentView(R.layout.activity_login);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.INTERNET)},1 );
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.ACCESS_NETWORK_STATE)},2 );
        }
        if(sp.getString("token", null)!=null)
        {
            
        }
    }

    public void login(View view) {
        EditText userEdt = findViewById(R.id.edtUsuario);
        EditText passEdt = findViewById(R.id.edtSenha);
        final LoginActivity mainActivity = this;
        String user = userEdt.getText().toString();
        String pass = passEdt.getText().toString();
        EndpointInterface api = RetrofitClass.retrofit.create(EndpointInterface.class);
        api.getAuth(new Auth( user, pass)).enqueue(new Callback<WSResponse>() {
            @Override
            public void onResponse(Call<WSResponse> call, Response<WSResponse> response) {
                try {
                    Log.d("tag", "DEUBOM");
                    SharedPreferences.Editor e = sp.edit();
                    e.putString("token", response.body().getToken());
                    e.commit();

                    Log.d("tag", sp.getString("token", null));
                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    myIntent.putExtra("token", response.body().getToken());
                    startActivity(myIntent);
                    finish();
                }
                catch (Exception e){
                    Log.e("tag", e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<WSResponse> call, Throwable t) {
                Log.d("tag", "FALHA CATASTRÓFICA");
                Log.d("tag", t.getMessage());
            }
        });
    }

    public void createUser(View view) {
        Intent myIntent = new Intent(this, UserFormActivity.class);
        startActivity(myIntent);

    }
}

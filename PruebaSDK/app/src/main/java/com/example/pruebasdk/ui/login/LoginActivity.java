package com.example.pruebasdk.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pruebasdk.R;
import com.example.pruebasdk.ui.login.LoginViewModel;
import com.example.pruebasdk.ui.login.LoginViewModelFactory;
import com.example.pruebasdk.databinding.ActivityLoginBinding;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    EditText username;
    Button btnGuardar;

    RequestQueue requestQueue;

    private static  String URL1 = "http://192.168.0.9/blinkid/save.php";


    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        requestQueue = Volley.newRequestQueue(this);

        initUi();

        btnGuardar.setOnClickListener(this);
    }

    private void initUi() {
        username = findViewById(R.id.username);

        btnGuardar = findViewById(R.id.btnGuardar);
    }

    /**Override**/
    @Override
    public void onClick(View v){
        int id = v.getId();

        if(id == R.id.btnGuardar){
            String sexDesc = username.getText().toString().trim();

            createUser(sexDesc);
        }
    }

    private void createUser(final String sexDesc) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("sexDesc",sexDesc);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
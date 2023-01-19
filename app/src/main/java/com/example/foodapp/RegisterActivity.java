package com.example.foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button register;
    RequestQueue request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        register = findViewById(R.id.register);
        TextView login = findViewById(R.id.login);

        request = Volley.newRequestQueue(this);

        register.setOnClickListener(view -> signupUser());

        final String url = "https://foodcity.onrender.com/test";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MY_APP", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MY_APP", error.getLocalizedMessage());
            }
        });

        request.add(stringRequest);

        login.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    private void signupUser() {
        Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean isValid = validateUserDetails(email, password);

        if (!isValid) {
            return;
        }

        final String url = "https://foodcity.onrender.com/test";

    }
    
    private boolean validateUserDetails(String email, String password) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Invalid email address");
            return false;
        }

        if (password.length() < 6) {
            passwordEditText.setError("Password is too short");
            return false;
        }

        return true;
    }
}
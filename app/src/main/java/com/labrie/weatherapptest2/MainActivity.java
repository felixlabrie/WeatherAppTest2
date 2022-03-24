package com.labrie.weatherapptest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.labrie.weatherapptest2.databinding.ActivityMainBinding;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        binding.getWeather.setOnClickListener(view -> {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

            if (binding.editCity.getText().toString().isEmpty()) {
                binding.weatherDataContainer.setText("Invalid entry. Enter a valid city name");
            }
            else {
                String requestUrl = R.string.url + binding.editCity.getText().toString() + R.string.APIKey;
                JsonObjectRequest
            }

        });

    }
}
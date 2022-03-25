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

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RequestQueue queue;
    private String apiKey="&appid=49300a7196dfb9fc473da69381a662e2";
    private String url = "https://api.openweathermap.org/data/2.5/weather?q=";

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
                String requestUrl = url + binding.editCity.getText().toString() + apiKey;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, requestUrl, null, response -> {
                    try {
                        String weatherData = response.getString("coord");
                        binding.weatherDataContainer.setText(weatherData);
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                }, error -> Log.d("Request", "onClick: request error"));
                queue.add(jsonObjectRequest);
            }

        });

    }
}
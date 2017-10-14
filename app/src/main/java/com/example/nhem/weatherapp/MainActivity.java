package com.example.nhem.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private EditText etCityName;
    private Button btnSearch;
    private TextView tvCityName;
    private TextView tvCountry;
    private TextView tvTemp;
    private TextView tvStatus;
    private TextView tvHumidity;
    private TextView tvWind;
    private TextView tvDate;

    private static String APP_ID = "229306d15b7cc8b1e88f3fc4a3eee1c1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCityName = (EditText) findViewById(R.id.et_cityname);
        btnSearch = (Button) findViewById(R.id.btn_search);
        tvCityName = (TextView) findViewById(R.id.tv_cityname);
        tvTemp = (TextView) findViewById(R.id.tv_temp);
        tvStatus = (TextView) findViewById(R.id.tv_status);
        tvHumidity = (TextView) findViewById(R.id.tv_humidity);
        tvDate = (TextView) findViewById(R.id.tv_date);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String city = etCityName.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.openweathermap.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GetWeatherService getWeatherService = retrofit.create(GetWeatherService.class);
                if (city == null) {
                    Toast.makeText(MainActivity.this, "Điền tên thành phố phù hợp", Toast.LENGTH_SHORT).show();
                } else {
                    getWeatherService.getWeatherData(city, APP_ID).enqueue(new Callback<MainObjectJSON>() {
                        @Override
                        public void onResponse(Call<MainObjectJSON> call, Response<MainObjectJSON> response) {
                            if (response.body() != null) {
                                tvCityName.setText("City: " + city.toString());
                                tvTemp.setText(String.format("%.1f ℃", response.body().getMain().getTemp() - 273.15));
                                tvStatus.setText("Main: "+response.body().getWeather().get(0).getMain());
                                tvHumidity.setText("Humidity: " + response.body().getMain().getHumidity() + "%");

                                //Set date
                                long l = Long.valueOf(response.body().getDt());
                                Date date = new Date(l * 1000L);
                                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("EEEE HH:mm dd-MM-yyyy ");
                                String day = simpleDateFormat.format(date);
                                tvDate.setText("TimeUpdate: "+day);
                            } else {
                                Toast.makeText(MainActivity.this, "Nhập tên thành phố phù hợp", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MainObjectJSON> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "No conection", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}

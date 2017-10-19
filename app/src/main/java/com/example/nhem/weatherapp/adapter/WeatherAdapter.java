package com.example.nhem.weatherapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nhem.weatherapp.R;
import com.example.nhem.weatherapp.forecastWeather.list.WeatherForecastListJSON;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by NHEM on 20/10/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private Context context;
    private List<WeatherForecastListJSON> weatherForecastListJSONList;

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime;
        TextView tvTemp;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            tvTemp = itemView.findViewById(R.id.tv_tempp);
            tvTime = itemView.findViewById(R.id.tv_time);
        }

        public void setData(WeatherForecastListJSON weather) {
            long l = Long.valueOf(weather.getDt());
            Date date = new Date(l * 1000L);
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM");
            String day = simpleDateFormat.format(date);
            tvTime.setText(day);
            tvTemp.setText(String.format("%.1f ℃", weather.getTemp().getDay() - 273.15));
        }

    }

    public WeatherAdapter(List<WeatherForecastListJSON> weatherForecastListJSONList) {
        this.weatherForecastListJSONList = weatherForecastListJSONList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_weather, parent, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.setData(weatherForecastListJSONList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherForecastListJSONList.size();
    }

}

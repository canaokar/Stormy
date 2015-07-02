package com.chocodroid.stormy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.chocodroid.stormy.adapters.DayAdapter;
import com.chocodroid.stormy.ui.MainActivity;
import com.chocodroid.stormy.weather.Day;

import java.util.Arrays;


public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables,parcelables.length,Day[].class);
        DayAdapter adapter = new DayAdapter(this, mDays);
        this.setListAdapter(adapter);
    }
}

package com.chocodroid.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hour implements Parcelable{

    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mIcon;
    private String mTimezone;

    public Hour() {}

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("K a");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        return  formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSummary);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
        dest.writeDouble(mTemperature);
        dest.writeLong(mTime);
    }

    private Hour(Parcel in) {
        mSummary = in.readString();
        mIcon = in.readString();
        mTimezone = in.readString();
        mTemperature = in.readDouble();
        mTime = in.readLong();
    }

    public static final Creator<Hour> CREATOR  = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}

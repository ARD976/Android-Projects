package com.example.earthquake;

public class EarthQuake {

    private double mMagnitude;

    private String mCityName;

    private long mDate;

    private String mURL;

    public EarthQuake(double  magnitude , String cityName , Long date , String URL){
        mMagnitude = magnitude;
        mCityName = cityName;
        mDate = date;
        mURL = URL;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmCityName() {
        return mCityName;
    }

    public long getmDate() {
        return mDate;
    }

    public String getmURL() {
        return mURL;
    }
}

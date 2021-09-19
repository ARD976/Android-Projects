package com.example.earthquake;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthQuakeAdapter(Activity context , ArrayList<EarthQuake> words){
        super(context , 0 , words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item , parent , false);
        }

        EarthQuake earthQuake = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(earthQuake.getmMagnitude());

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthQuake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeView.setText(output);

        String firstLocation , secondLocation;
        String givenLocation = earthQuake.getmCityName();
        if(givenLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = givenLocation.split(LOCATION_SEPARATOR);
            firstLocation = parts[0] + LOCATION_SEPARATOR;
            secondLocation = parts[1];
        }else{
            firstLocation = getContext().getString(R.string.near_by);
            secondLocation = givenLocation;
        }

        TextView beforecityView = (TextView) listItemView.findViewById(R.id.beforecity);
        beforecityView.setText(firstLocation);

        TextView cityView = (TextView) listItemView.findViewById(R.id.city);
        cityView.setText(secondLocation);

        Date dateObject = new Date(earthQuake.getmDate());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = dateFormat(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = timeFormat(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String dateFormat(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd , yyyy");
        return dateFormat.format(dateObject);
    }

    private String timeFormat(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h : mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch(magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext() , magnitudeColorResourceId);
    }

}

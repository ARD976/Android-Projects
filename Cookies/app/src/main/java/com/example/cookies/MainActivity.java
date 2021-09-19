package com.example.cookies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.cookies.R.drawable.after_cookie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EatCookie(View view) {
        displayImage();
        displayMessage();
    }

    private void displayMessage(){
        TextView hungaryForCookie = (TextView) findViewById(R.id.hungary_for_cookie);
        hungaryForCookie.setText("I'm so full");
    }

    private void displayImage(){
        ImageView beforeCookie = (ImageView) findViewById(R.id.before_cookie);
        beforeCookie.setImageResource(after_cookie);
    }
}
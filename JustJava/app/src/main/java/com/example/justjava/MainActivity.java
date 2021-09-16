package com.example.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText editText = (EditText)  findViewById(R.id.edit_text);
        String name = editText.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checked_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice( hasWhippedCream ,  hasChocolate);
        String message = createOrderSummary(price , name , hasWhippedCream , hasChocolate);
        //displayMessage(message);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL , "amanrajdevesh75490@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT , "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT , message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void increment(View view) {
        if(quantity == 100){
            return;
        }else {
            quantity = quantity + 1;
        }
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity == 1){
            return;
        }else {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean hasWhippedCream , boolean hasChocolate) {
        int basePrice = 5;

        if(hasWhippedCream){
            basePrice += 1;
        }

        if(hasChocolate){
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    private String createOrderSummary(int price ,String name1 , boolean hasWhippedCream , boolean hasChocolate){
        String name = "Name : " + name1;
        name += "\nHas Whipped Cream? " + hasWhippedCream;
        name += "\nHas Chocolate? " + hasChocolate;
        name += "\nQuantity : " + quantity;
        name += " \nTotal :$ " + price;
        name += "\nThank You!";
        return name;
    }

}
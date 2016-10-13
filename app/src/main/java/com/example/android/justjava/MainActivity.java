package com.example.android.justjava;
/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 2;
    public void increment(View view){
        quantity++;
        display(quantity);
    }
    public void decrement(View view){
        quantity--;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText namefield = (EditText)findViewById(R.id.name_EditText);
        String name = namefield.getText().toString();
        CheckBox whippedCream = (CheckBox)findViewById(R.id.whipped_cream_CheckBox);
        boolean hasWhippedCream = whippedCream.isChecked();
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate_CheckBox);
        boolean hasChocolate = chocolate.isChecked();
        int price = 5;
        if(hasWhippedCream)
            price+=1;
        if(hasChocolate)
            price+=2;
        price*=quantity;
        StringBuilder str1 = new StringBuilder();
        str1.append("Name:"+name+"\n");
        str1.append("Add whipped cream? "+hasWhippedCream+"\n");
        str1.append("Add Chocolate? "+hasChocolate+"\n");
        str1.append("Quantity:"+quantity+"\n");
        str1.append("Total Price:$"+price+"\n");
        str1.append("Thank you");
        displayMessage(str1.toString());

    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}

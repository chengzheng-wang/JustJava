package com.example.android.justjava;
/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.order;

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
        if(quantity>100){
            quantity=100;
            Toast.makeText(this,"You can not order more than 100 cups",Toast.LENGTH_SHORT).show();
            return;
        }
        display(quantity);
    }
    public void decrement(View view){
        quantity--;
        if(quantity<1) {
            quantity = 1;
            Toast.makeText(this,"You can not order less than 1 cup",Toast.LENGTH_SHORT).show();
            return;
        }
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
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just java order for"+name);
        intent.putExtra(Intent.EXTRA_TEXT,str1.toString());
        //有可以接住这个intent的应用，那么就执行这个intent
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else
            {
                Toast.makeText(this,"No apps",Toast.LENGTH_SHORT).show();
            }

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}

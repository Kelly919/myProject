package com.example.inventorymanagementsystem;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Inventory extends AppCompatActivity {

    private EditText editTextTextPersonName3;
    private EditText editTextNumber2;
    private EditText editTextNumber4;
    private EditText editTextTextPersonName8;

    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;

    myDBAdapter dbInventory;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        editTextNumber4 = (EditText) findViewById(R.id.editTextNumber4);
        editTextTextPersonName8 = (EditText) findViewById(R.id.editTextTextPersonName8);

        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);

        dbInventory = new myDBAdapter(this);


    }

    public void Add(View view){
        String productName = editTextTextPersonName3.getText().toString();
        String productQuality = editTextNumber2.getText().toString();
        String productPrice = editTextNumber4.getText().toString();
        String productDescription = editTextTextPersonName8.getText().toString();
        if (productName.isEmpty()||productQuality.isEmpty()||productPrice.isEmpty()||productDescription.isEmpty())
        {
            Message.message(getApplicationContext(),"Please Enter Name, Quality, Price and Description...");
        }
        else
        {
            long id =  dbInventory.insertData(productName,productQuality,productPrice,productDescription);
            if (id<=0)
            {
                Message.message(getApplicationContext(),"Not Successful...");
                editTextTextPersonName3.setText("");
                editTextNumber2.setText("");
                editTextNumber4.setText("");
                editTextTextPersonName8.setText("");
            }
            else
            {
                Message.message(getApplicationContext()," Successful...");
                editTextTextPersonName3.setText("");
                editTextNumber2.setText("");
                editTextNumber4.setText("");
                editTextTextPersonName8.setText("");
            }
        }
    }

    public void View(View view){
        String Products = dbInventory.viewProducts();
        Message.message(this,Products);

    }

    public void Update(View view){
        String productName2 = editTextTextPersonName3.getText().toString();
        String productQuality2 = editTextNumber2.getText().toString();
        String productPrice2 = editTextNumber4.getText().toString();
        String productDescription2 = editTextTextPersonName8.getText().toString();
        if (productName2.isEmpty()||productQuality2.isEmpty()||productPrice2.isEmpty()||productDescription2.isEmpty())
        {
            Message.message(getApplicationContext()," Enter Products");
        }
        else
        {
            int b = dbInventory.UpdateProducts(productName2,productQuality2,productPrice2,productDescription2);
            if (b<=0)
            {
                Message.message(getApplicationContext(),"Not Successful...");
                editTextTextPersonName3.setText("");
                editTextNumber2.setText("");
                editTextNumber4.setText("");
                editTextTextPersonName8.setText("");
            }
            else
            {
                Message.message(getApplicationContext()," Updated...");
                editTextTextPersonName3.setText("");
                editTextNumber2.setText("");
                editTextNumber4.setText("");
                editTextTextPersonName8.setText("");
            }
        }
    }

    public void Delete(View view){
        String delete = editTextTextPersonName3.getText().toString();
        if (delete.isEmpty())
        {
            Message.message(getApplicationContext()," Enter Products");
        }
        else
        {
            int b = dbInventory.editTextTextPersonName3(delete);
            if(b<=0)
            {
                Message.message(getApplicationContext()," Not Successful ...");
                editTextTextPersonName3.setText("");
            }
            else
            {
                Message.message(getApplicationContext()," Deleted...");
                editTextTextPersonName3.setText("");
            }
        }

    }


}
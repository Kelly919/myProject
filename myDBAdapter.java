package com.example.inventorymanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class myDBAdapter {
    InventoryDB myhelper;
    public myDBAdapter(Context context)
    {
        myhelper = new InventoryDB(context);
}

    static class InventoryDB extends SQLiteOpenHelper {

        private static final String Database_Name = "ProductsDb";
        private static final String Table_Name = "Products";
        private static final int  Database_Version = 1;
        private static final String ID = "id";
        private static final String ProductName = "Name()";
        private static final String ProductQuantity = "Quantity";
        private static final String ProductPrice = "Price";
        private static final String ProductDescription = "Description";

        private static final String CREATE_TABLE = "CREATE TABLE " + Table_Name+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +ProductName+"TEXT,"
                +ProductQuantity+" INTEGER PRIMARY KEY,"
                +ProductPrice+"INTEGER PRIMARY KEY,"
                +ProductDescription+"TEXT);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Table_Name;
        private  Context context;


        public InventoryDB( Context context ) {
            super(context , Database_Name , null , 1);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
            }catch (Exception e){
                Message.message(context ,""+e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion) {

            try{
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e){
                Message.message(context ,""+e);
            }


        }
    }

    public long insertData(String name , String quantity , String price , String description) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryDB.ProductName, name);
        contentValues.put(InventoryDB.ProductQuantity, quantity);
        contentValues.put(InventoryDB.ProductPrice, price);
        contentValues.put(InventoryDB.ProductDescription, description);
        long id = db.insert(InventoryDB.Table_Name, null, contentValues);

        return id;
    }

    public String viewProducts() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String [] columns = {InventoryDB.ID,InventoryDB.ProductName,InventoryDB.ProductQuantity
                ,InventoryDB.ProductPrice,InventoryDB.ProductDescription};
        Cursor cursor = db.query(InventoryDB.Table_Name,columns,null,null,null,null,null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext())
        {
            int Id= cursor.getInt(cursor.getColumnIndex(InventoryDB.ID));
            String name = cursor.getString(cursor.getColumnIndex(InventoryDB.ProductName));
            String quantity = cursor.getString(cursor.getColumnIndex(InventoryDB.ProductQuantity));
            String price = cursor.getString(cursor.getColumnIndex(InventoryDB.ProductPrice));
            String description = cursor.getString(cursor.getColumnIndex(InventoryDB.ProductDescription));
            buffer.append(Id+""+name+""+quantity+""+price+""+description+"\n");

        }

        return buffer.toString();
    }

    public int UpdateProducts(String productName2 , String productQuality2 ,
                              String productPrice2 , String productDescription2) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(InventoryDB.ProductName,productName2);
        String [] whereArgs = {productName2};
        int count= db.update(InventoryDB.Table_Name,contentValues,InventoryDB.ProductName+"=?",whereArgs);

    return count;
    }

    public int editTextTextPersonName3(String delete) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String [] whereArgs = {delete};

        int count = db.delete(InventoryDB.Table_Name,InventoryDB.ProductName+"=?",whereArgs);
        return count;



    }



}

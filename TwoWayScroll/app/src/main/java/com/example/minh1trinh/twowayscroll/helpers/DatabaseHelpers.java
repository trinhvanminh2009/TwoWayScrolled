package com.example.minh1trinh.twowayscroll.helpers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;

import com.example.minh1trinh.twowayscroll.obj.CheckBoxObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh1.trinh on 12/5/2017.
 */

public class DatabaseHelpers extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "scroll_two_way.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "check_box_is_checked";
    private static final String KEY_ID = "id";
    private static final String NAME = "name";
    private static final String IS_CHECKED = "is_checked";
    private Context context;

    public DatabaseHelpers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public DatabaseHelpers(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE_IS_CHECKED = "create table " + TABLE_NAME + "(" + KEY_ID
                + " INTEGER PRIMARY KEY, " + NAME + " TEXT not null, " + IS_CHECKED + " INTEGER not null )";
        sqLiteDatabase.execSQL(CREATE_TABLE_IS_CHECKED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "CHECKBOX_IS_CHECKED");
        onCreate(sqLiteDatabase);
    }

    public void insertCheckBox(CheckBoxObject checkBox) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, checkBox.getTextCheckBox());
        if (checkBox.getChecked()) {
            contentValues.put(IS_CHECKED, 1);
        } else {
            contentValues.put(IS_CHECKED, 0);
        }

        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public int updateCheckBox(CheckBoxObject checkBox) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, checkBox.getTextCheckBox());
        if (checkBox.getChecked()) {
            contentValues.put(IS_CHECKED, 1);
        } else {
            contentValues.put(IS_CHECKED, 0);
        }
      //  Log.e("Update", checkBox.getTextCheckBox() + " and " + checkBox.getChecked());

        return db.update(TABLE_NAME, contentValues, KEY_ID + " ="+checkBox.getId(),null);
    }

    public void updateCheckBox1(CheckBoxObject checkBoxObject){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql;
        if(checkBoxObject.getChecked()){
          sql = "update " + TABLE_NAME + " set " + IS_CHECKED + " = 1"
                    + " where " + NAME + " = '"+ checkBoxObject.getTextCheckBox() + "'";
        }else{
            sql = "update " + TABLE_NAME + " set " + IS_CHECKED + " = 0"
                    + " where " + NAME + " = '"+ checkBoxObject.getTextCheckBox() + "'";
        }


        db.execSQL(sql);
    }

    public int getCountCheckBox(){
        int count;
        String countQuery  = "Select * from "+ TABLE_NAME ;
        SQLiteDatabase database = this.getReadableDatabase();
        database.isOpen();
        Cursor cursor = database.rawQuery(countQuery, null);
        count = cursor.getCount();
        cursor.close();
        return count;
    }

    public List<CheckBoxObject>getAllCheckBoxTrue(){
        List<CheckBoxObject>checkBoxList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                CheckBoxObject checkBox = new CheckBoxObject();
                checkBox.setId(cursor.getInt(0));
                checkBox.setTextCheckBox(cursor.getString(1));
                int isChecked = cursor.getInt(2);
                if(isChecked == 0){
                    checkBox.setChecked(false);
                }else if (isChecked ==1){
                    checkBox.setChecked(true);
                }
                checkBoxList.add(checkBox);

            }while (cursor.moveToNext());
        }
        List<CheckBoxObject>listCheckBoxTrue = new ArrayList<>();
        for(int i = 0 ; i < checkBoxList.size(); i++){
            if(checkBoxList.get(i).getChecked()){
                listCheckBoxTrue.add(checkBoxList.get(i));
            }
        }
        return listCheckBoxTrue;
    }

    public List<CheckBoxObject>getAllCheckBoxFalse(){
        List<CheckBoxObject>checkBoxList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                CheckBoxObject checkBox = new CheckBoxObject();
                checkBox.setId(cursor.getInt(0));
                checkBox.setTextCheckBox(cursor.getString(1));
                int isChecked = cursor.getInt(2);
                if(isChecked == 0){
                    checkBox.setChecked(false);
                }else if (isChecked ==1){
                    checkBox.setChecked(true);
                }
                checkBoxList.add(checkBox);

            }while (cursor.moveToNext());
        }
        List<CheckBoxObject>listCheckBoxFalse = new ArrayList<>();
        for(int i = 0 ; i < checkBoxList.size(); i++){
            if(!checkBoxList.get(i).getChecked()){
                listCheckBoxFalse.add(checkBoxList.get(i));
            }
        }
        return listCheckBoxFalse;
    }

    public List<CheckBoxObject>getAllCheckBox(){
        List<CheckBoxObject>checkBoxList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                CheckBoxObject checkBox = new CheckBoxObject();
                checkBox.setId(cursor.getInt(0));
                checkBox.setTextCheckBox(cursor.getString(1));
                int isChecked = cursor.getInt(2);
                if(isChecked == 0){
                    checkBox.setChecked(false);
                }else if (isChecked ==1){
                    checkBox.setChecked(true);
                }
                checkBoxList.add(checkBox);

            }while (cursor.moveToNext());
        }

        return checkBoxList;
    }
}

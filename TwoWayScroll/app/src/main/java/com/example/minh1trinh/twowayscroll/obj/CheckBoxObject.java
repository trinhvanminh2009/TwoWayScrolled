package com.example.minh1trinh.twowayscroll.obj;

/**
 * Created by minh1.trinh on 12/5/2017.
 */

public class CheckBoxObject {
    private int id;
    private String textCheckBox;
    private Boolean isChecked;
    public CheckBoxObject(){

    }

    public CheckBoxObject(String textCheckBox, Boolean isChecked) {
        this.textCheckBox = textCheckBox;
        this.isChecked = isChecked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextCheckBox() {
        return textCheckBox;
    }

    public void setTextCheckBox(String textCheckBox) {
        this.textCheckBox = textCheckBox;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}

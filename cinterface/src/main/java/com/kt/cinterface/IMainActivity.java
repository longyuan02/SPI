package com.kt.cinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kt.libinterface.LDisplay;

public class IMainActivity extends AppCompatActivity implements LDisplay {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_main);
    }

    @Override
    public String display() {
        return "cinterface_string";
    }
}

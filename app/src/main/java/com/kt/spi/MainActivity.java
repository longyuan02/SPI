package com.kt.spi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kt.libinterface.LDisplay;

import java.util.ServiceLoader;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    StringBuilder mStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStringBuilder = new StringBuilder();
        textView = findViewById(R.id.tvShow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadModule();
            }
        });
    }

    private void loadModule() {
        String display = "";
        while (DisplayFactory.getSingleton().hasNextDisplay()) {
            display = DisplayFactory.getSingleton().getDisplay().display();
            mStringBuilder.append(display).append("\n");
        }
        textView.setText(mStringBuilder.toString());
    }
}

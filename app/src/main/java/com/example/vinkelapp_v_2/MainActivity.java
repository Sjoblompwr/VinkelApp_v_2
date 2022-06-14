package com.example.vinkelapp_v_2;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.vinkelapp_v_2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCanvas = new MyCanvas(this);
        setContentView(myCanvas);
    }




}
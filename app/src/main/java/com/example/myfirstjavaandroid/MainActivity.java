package com.example.myfirstjavaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = getIntent().getExtras().getString("ps");
        TextView mTextView = findViewById(R.id.tvMain);
        mTextView.setText(name);
    }


    public void onClickHandler(View view) {
        Toast.makeText(this, "Hellllloo", Toast.LENGTH_SHORT).show();
        Intent mIntent;
        mIntent = new Intent(MainActivity.this,HomePage.class);
        mIntent.putExtra("SS","Suprith Singh");
        startActivity(mIntent);
    }
}
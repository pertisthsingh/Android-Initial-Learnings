package com.example.myfirstjavaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myfirstjavaandroid.data.Datasource



class HomePage : AppCompatActivity() {

    lateinit var etMail :EditText;
    lateinit var etPhone : EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        etMail = findViewById(R.id.emailAddress);
        etPhone = findViewById(R.id.phoneNumber);

    }

    override fun onPause() {
        super.onPause()
        storeState();
    }

    private fun storeState() {
        var email: String = etMail.text.toString();
        var phone : String = etPhone.text.toString();

        var sharePreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE);

        var editor = sharePreferences.edit();

        editor.putString("email",email);
        editor.putString("phone",phone);

        editor.apply();
    }

    override fun onResume() {
        super.onResume()
        restoreState();
    }

    private fun restoreState() {
        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE);

        var email = sharedPreferences.getString("email","");
        var phone = sharedPreferences.getString("phone","");

        etMail.setText(email);
        etPhone.setText(phone);
    }


}
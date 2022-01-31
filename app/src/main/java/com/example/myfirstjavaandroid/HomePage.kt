package com.example.myfirstjavaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomePage : AppCompatActivity() {
    var TAG:String = HomePage::class.java.simpleName
    lateinit var etMail :EditText;
    lateinit var etPhone : EditText;
    lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        db = Firebase.firestore
        etMail = findViewById(R.id.emailAddress);
        etPhone = findViewById(R.id.phoneNumber);

    }

    fun firestoreHandler(view: android.view.View) {
        when(view.id){
            R.id.send ->{
                onSend()
            }
            R.id.fetch -> {
                onFetch()
            }
        }
    }

    private fun onSend(){
        var email = etMail.text.toString()
        var phone = etPhone.text.toString()

        Log.d(TAG,"Email");

        val user = hashMapOf(
                "email" to "Ada",
                "phone" to "Lovelace"
        )

        db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
    }

    private fun onFetch(){
        db.collection("users")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }
    }

    override fun onPause() {
        super.onPause()
//        storeState();
    }





//    private fun storeState() {
//        var email: String = etMail.text.toString();
//        var phone : String = etPhone.text.toString();
//
//        var sharePreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE);
//
//        var editor = sharePreferences.edit();
//
//        editor.putString("email",email);
//        editor.putString("phone",phone);
//
//        editor.apply();
//    }

    override fun onResume() {
        super.onResume()
//        restoreState();
    }

//    private fun restoreState() {
//        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE);
//
//        var email = sharedPreferences.getString("email","");
//        var phone = sharedPreferences.getString("phone","");
//
//        etMail.setText(email);
//        etPhone.setText(phone);
//    }


}
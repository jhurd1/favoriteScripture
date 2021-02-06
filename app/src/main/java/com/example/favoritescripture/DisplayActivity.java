package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    String _book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        _book = intent.getStringExtra(MainActivity.BOOK_PART);
        TextView scriptureLabel = (TextView) findViewById(R.id.textView);
        scriptureLabel.setText(_book);
    }

    public void onSaveScripture(View theButton)
    {
        /*SharedPreferences can store and retrieve data to and from a file.*/
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);

        /*SharedPreferences editor modifies values in the SP object.*/
        SharedPreferences.Editor editor = sharedPrefs.edit();

        /*putString of Editor object of SP object;
        * sets a string value in the preferences editor;
        * gets "written back" when commit() or apply() are
        * called.*/
        editor.putString(MainActivity.BOOK_PART, _book);

        /*As aforementioned, putString writes when apply
        * is called. Apply() commits changes from the
        * Editor object to the SP object.*/
        editor.apply();

        /*A toast constitutes a short message for the user.
        * makeText(), when possessing three arguments,
        * produces a text message. LENGTH_SHORT
        * comprises a predetermined, shorter length of time.*/
        Toast.makeText(this, "Scripture saved.", Toast.LENGTH_SHORT).show();


        /*Intent can be used to start an activity, send data to components, or communicate
        * with a service.
        Intent scriptureIntent = new Intent(this, DisplayActivity.class);*/
    }
}
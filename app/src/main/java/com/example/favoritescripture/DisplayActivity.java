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
import android.util.Log;

public class DisplayActivity extends AppCompatActivity {

    private String _book; // making this private made it run slower
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        _book = intent.getStringExtra(MainActivity.BOOK_PART);
        Log.d(TAG, "Received intent.");
        TextView scriptureLabel = (TextView) findViewById(R.id.lblScripture);
        scriptureLabel.setText(_book);
    }

    public void onSaveScripture(View saveScripture)
    {
        /*SharedPreferences can store and retrieve data to and from a file.*/
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);

        /*SharedPreferences editor modifies values in the SP object.*/
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString(MainActivity.BOOK_PART, _book);

        editor.apply();

        Toast.makeText(this, "Scripture saved.", Toast.LENGTH_SHORT).show();

    }
}
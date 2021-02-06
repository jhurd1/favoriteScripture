package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // These represent containers (variables) for saving data to
    public static final String BOOK_PART = "BOOK_PART";
    public static final String APP_PREFS = "APPLICATION_PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDisplayScripture(View theButton)
    {
        EditText txtBook = (EditText) findViewById(R.id.txtBook);
        String book = txtBook.getText().toString();
        Intent scriptureIntent = new Intent(this, DisplayActivity.class);
        scriptureIntent.putExtra(BOOK_PART, book);
        startActivity(scriptureIntent);
    }
}
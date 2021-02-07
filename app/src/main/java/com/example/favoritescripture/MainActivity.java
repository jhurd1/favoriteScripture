package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // These represent containers (variables) for saving data to
    public static final String BOOK_PART = "BOOK_PART";
    public static final String APP_PREFS = "APPLICATION_PREFERENCES";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Favorite Scripture");
    }

    public void onDisplayScripture(View buttonDisplay)
    {
        EditText txtBook = (EditText) findViewById(R.id.txtBook);
        String book = txtBook.getText().toString();

        /*Add a debug log message to the first activity's button handler code that is invoked
        before the intent is created. This message should say something like: "About to create
        intent with John 3:16.*/

        Log.d(TAG, "About to create intent with your book");
        /*When you click the display scripture button it should take you the the DisplayActivity
        and, if your save button is in the activity_display.xml, it should show at that time.*/
        Intent scriptureIntent = new Intent(this, DisplayActivity.class);

        scriptureIntent.putExtra(BOOK_PART, book);
        startActivity(scriptureIntent);
    }

    public void onLoadScripture(View buttonDisplay)
    {
        SharedPreferences sharedPref = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);

        /*In this case, with a SharedPreferences object,
        * getString() holds two parameters and retrieves a string value
        * from the SP object.*/
        String book = sharedPref.getString(BOOK_PART, null);

        EditText txtBook = (EditText) findViewById(R.id.txtBook);
        //txtBook.setText(book); // new line
    }
}
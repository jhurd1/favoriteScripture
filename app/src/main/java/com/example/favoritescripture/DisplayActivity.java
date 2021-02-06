package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);
    }

    public void onDisplayScripture(View theButton)
    {
        EditText txtBook = {EditText} findViewById(R.id.txtBook);
        String book = txtBook.getText().toString();
        Intent scriptureIntent = new Intent(this, DisplayActivity.class);
    }
}
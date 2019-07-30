package com.example.pc.rdwrapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.eT);
        read();
    }

    public void clicked(View view) {
        s = editText.getText().toString();
        if(!s.isEmpty())
        {
        try {
            FileOutputStream fileOutputStream = openFileOutput("Diary.txt", MODE_PRIVATE);
            fileOutputStream.write(s.getBytes());
            fileOutputStream.close();
            Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        else {
            Toast.makeText(MainActivity.this, "Enter Some Data", Toast.LENGTH_SHORT).show();
        }
    }

    public void read() {

        try {

            FileInputStream fileInputStream = openFileInput("Diary.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String x = bufferedReader.readLine();
            if (x != null) {
                editText.setText(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

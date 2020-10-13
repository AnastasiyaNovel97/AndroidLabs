package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.androidlabs.Service.MyIntentService;
import com.example.androidlabs.Service.MyService;

public class Lab1 extends AppCompatActivity {

    EditText editText;
    final static int RESULT = 0;
    public void onClick(View v)
    {
        Intent i = new Intent(this, Lab2_3.class);

        i.putExtra("text",editText.getText().toString());
        startActivityForResult(i, RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT)
        {
            if(resultCode== RESULT_OK)
            {
                Toast.makeText(this,data.getStringExtra("answer"), Toast.LENGTH_LONG).show();
                ((TextView)findViewById(R.id.textViewLab2_A)).setText(data.getStringExtra("answer"));
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        editText = (EditText) findViewById(R.id.editTextA);
        ImageButton imageButtonStart = findViewById(R.id.ButtonPlay);
        ImageButton imageButton2Stop = findViewById(R.id.ButtonStop);
        imageButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(Lab1.this, MyService.class));
               // Toast.makeText(getApplicationContext(),"Привет", Toast.LENGTH_LONG).show();
            }
        });
        imageButton2Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(Lab1.this, MyService.class));
            }
        });
    }
}

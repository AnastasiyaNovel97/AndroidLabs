package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.androidlabs.Service.MyIntentService;
import com.example.androidlabs.Service.MyService;

public class Lab2_3 extends AppCompatActivity {

    TextView textView;
    EditText editText;
    ServiceConnection sConn;
    boolean bound = false;
    MyService myService;

    public void onClick(View v)
    {
        Intent answerIntent = new Intent(this, Lab1.class);
        answerIntent.putExtra("answer", editText.getText().toString());
        setResult(RESULT_OK, answerIntent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_3);
        textView = findViewById(R.id.textViewLab2_B);
        editText = findViewById(R.id.editTextB);
        textView.setText(getIntent().getStringExtra("text"));

        sConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder binder) {
                bound = true;
                myService = ((MyService.MyBinder) binder).gerService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bound = false;

            }
        };
        ImageButton bBindService = findViewById(R.id.ButtonPlayB);
        bBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(new Intent(Lab2_3.this, MyService.class), sConn, BIND_AUTO_CREATE);
            }
        });

        ImageButton bUnBindService = findViewById(R.id.ButtonStopB);
        bUnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound)
                    unbindService(sConn);
                bound = false;
            }
        });

        Button buttonOn = findViewById(R.id.VolumeOn);
        buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound) {
                    myService.setVolume(1f);
                }
            }
        });
        Button buttonOff = findViewById(R.id.VolumeOff);
        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound) {
                    myService.setVolume(0.0f);
                }
            }
        });

        Button IntentService = findViewById(R.id.IntentService);
        IntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMyIntentService = new Intent(Lab2_3.this, MyIntentService.class);

                startService(intentMyIntentService.putExtra("time", 3).putExtra("task",
                        "Как легко обидеть человека!"));
                startService(intentMyIntentService.putExtra("time", 1).putExtra("task",
                        "Взял и бросил фразу злее перца."));
                startService(intentMyIntentService.putExtra("time", 4).putExtra("task",
                        "А потом порой не хватит века,"));
                startService(intentMyIntentService.putExtra("time", 4).putExtra("task",
                        "Чтоб вернуть обиженное сердце!"));
            }
        });
    }
}

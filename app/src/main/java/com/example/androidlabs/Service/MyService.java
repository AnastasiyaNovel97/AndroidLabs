package com.example.androidlabs.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import com.example.androidlabs.R;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate(){

        super.onCreate();
        Toast.makeText(this,"Служба создана", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "Служба запущена", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Служба отключена", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }


    public MyService() {
    }
public class MyBinder extends Binder
    {
        public MyService gerService()
        {
            return MyService.this;
        }
    }

    public void setVolume(float volume)
    {

           mediaPlayer.setVolume(volume,volume);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       Toast.makeText(this,"Служба подключена", Toast.LENGTH_SHORT).show();
       mediaPlayer.start();
       return myBinder;
    }
}

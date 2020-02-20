package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityone extends AppCompatActivity {
MediaPlayer media;
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityone);
        btn1=(Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media=MediaPlayer.create(getApplicationContext(),R.raw.ingoma);
                media.start();
            }
        });
        btn2=(Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(media!=null && media.isPlaying()){
                    media.stop();
                }
            }
        });
    }
}

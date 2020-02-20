package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class activitytwo extends AppCompatActivity {
TextView  txt;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitytwo);

        txt=findViewById(R.id.textView3);
        btn=(Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f="";
                try{
                    InputStream stream=getAssets().open("cee.c");
                    int z=stream.available();
                    byte[] space=new byte[z];
                    stream.read(space);
                    stream.close();
                    f=new String(space);

                }
                catch(IOException s){
                    s.printStackTrace();
                }
                txt.setText((CharSequence) f);
            }
        });
    }
}

package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button list;
ProgressBar progressBar;

private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        int x=intent.getIntExtra("level",0);
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setProgress(x);
        TextView textView=findViewById(R.id.leveltxt);
        textView.setText("Battery level"+Integer.toString(x)+"%");
    }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        list=findViewById(R.id.button4);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.example.myfirstcreation.list.class);
                startActivity(intent);

            }
        });

    }
    public void alarmPhase(View view){
        EditText editText=(EditText)findViewById(R.id.seconds);
        int i=Integer.parseInt(editText.getText().toString());
        Intent intent=new Intent(this,BroadcastReceiver.class);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i *1000),pendingIntent);
        Toast.makeText(this,"Alarm is in"+ i + "seconds",Toast.LENGTH_SHORT).show();
    }
    public void sendMessage(View view){
        EditText message=(EditText)findViewById(R.id.message);
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        Toast.makeText(this, "sending a message", Toast.LENGTH_SHORT).show();
        intent.        putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menue, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.first:
                startActivity(new Intent(this,activityone.class));
                // do your code
                return true;
            case R.id.email:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String to[]={"abiasperfect411@gmail.com","rkimera@must.ac.ug","ktsmsuzan@gmil.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"good afternoon");
                intent.putExtra(Intent.EXTRA_TEXT,"It has been long, anyway where have you been");
                intent.setType("message/rfc 822");
                startActivity(intent);
                return true;
            case R.id.Call:
                try{
                    int permit= ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                            Toast.makeText(this, "Please make a call", Toast.LENGTH_LONG).show();
                        }
                        else {
                            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
                        }

                    }
                    Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:0781732893"));
                    startActivity(in);
                }
                catch (Exception e){
                    e.printStackTrace();

                }
                return true;


            case R.id.second:
                startActivity(new Intent(this,activitytwo.class));
                // do your code
                return true;
             default:
                return super.onOptionsItemSelected(item);
        }
    }
}


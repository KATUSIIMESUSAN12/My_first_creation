package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.button4);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.example.myfirstcreation.list.class);
                startActivity(intent);
            }
        });
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
            case R.id.second:
                startActivity(new Intent(this,activitytwo.class));
                // do your code
                return true;
             default:
                return super.onOptionsItemSelected(item);
        }
    }
}


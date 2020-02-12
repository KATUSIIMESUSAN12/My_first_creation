package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        EditText message=(EditText)findViewById(R.id.message);
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        Toast.makeText(this, "sending a message", Toast.LENGTH_SHORT).show();
        intent.        putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");

    }
}

package com.example.captchasample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.captchasample.util.CaptchaImageView;

public class MainActivity extends AppCompatActivity {
    ImageView refreshButton;
    EditText captchaInput;
    Button submitButton;
    CaptchaImageView captchaImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshButton= (ImageView) findViewById(R.id.regen);
        captchaInput= (EditText) findViewById(R.id.captchaInput);
        submitButton= (Button) findViewById(R.id.submitButton);
        captchaImageView= (CaptchaImageView) findViewById(R.id.image);
        captchaImageView.setCaptchaType(CaptchaImageView.CaptchaGenerator.BOTH);
        //captchaImageView.setIsDotNeeded(true); //do this if you need dotted background
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captchaImageView.regenerate();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(captchaInput.getText().toString().equals(captchaImageView.getCaptchaCode())){
                    Toast.makeText(MainActivity.this, "Matched", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
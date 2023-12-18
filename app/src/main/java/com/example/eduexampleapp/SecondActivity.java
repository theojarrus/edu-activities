package com.example.eduexampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eduexampleapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    private static final String EXTRA_TEXT_KEY = "extra_text_key";

    public static Intent createIntent(Context context, String text) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT_KEY, text);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String data = getIntent().getStringExtra(EXTRA_TEXT_KEY);
        binding.field.setText(data);

        setResult();
    }

    private void setResult() {
        Intent intent = new Intent();
        intent.putExtra("data", "Mydata");
        setResult(100, intent);
    }
}

package com.example.eduexampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eduexampleapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Context - класс Android для получения данных ресурсов
        Context context = this;
        String text = context.getResources().getText(R.string.sample_text).toString();
        binding.buttonToast.setOnClickListener(v -> Toast.makeText(this, text, Toast.LENGTH_SHORT).show());

        binding.buttonCamera.setOnClickListener(v -> startCamera());
        binding.buttonSecondActivity.setOnClickListener(v -> startSecondActivity());
    }

    private void startCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private void startSecondActivity() {
        Intent intent = SecondActivity.createIntent(this, "Example text");
        startActivityForResult(intent, 100);
    }

    // Use launcher instead
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.wtf("LOGG", "result");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycleCheckTag", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycleCheckTag", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycleCheckTag", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycleCheckTag", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycleCheckTag", "onDestroy");
    }
}

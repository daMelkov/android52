package ru.startandroid.develop.melkovhw52;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TransferActivity extends AppCompatActivity {

    final private static String URL = "http://myfile.org/" + new Random().nextInt(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        /* Кнопка "Назад" */
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /* Кнопка "Вперёд" */
        Button btnForward = findViewById(R.id.btnForward);
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransferActivity.this, TransferActivity.class);
                startActivity(intent);
            }
        });

        /* URL фотографии */
        TextView textView = findViewById(R.id.url);
        textView.setText(URL);
    }
}
package ru.startandroid.develop.melkovhw52;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_tasks:
                intent = new Intent(MainActivity.this, TasksActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_cities:
                intent = new Intent(MainActivity.this, CitiesActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_check:
                intent = new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_monitoring:
                intent = new Intent(MainActivity.this, MedicalActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_transfer:
                intent = new Intent(MainActivity.this, TransferActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_form:
                intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_first_b:
                intent = new Intent(MainActivity.this, SplashScreenActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_first_a:
                intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
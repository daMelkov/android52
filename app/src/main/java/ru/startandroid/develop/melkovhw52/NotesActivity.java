package ru.startandroid.develop.melkovhw52;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {
    private static final String NOTE_TEXT = "note_text";

    private EditText mInputNote;
    private Button mBtnSaveNote;

    private SharedPreferences myNoteSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        /* Note description */
        mInputNote = findViewById(R.id.inputNote);

        /* Preferences */
        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        /* Save */
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();

                String noteTxt = mInputNote.getText().toString();

                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();

                Toast.makeText(NotesActivity.this, getString(R.string.data_saved), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }
}
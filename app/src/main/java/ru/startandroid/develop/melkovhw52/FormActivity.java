package ru.startandroid.develop.melkovhw52;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        /* Имя пользователя */
        final EditText editUserName = findViewById(R.id.editUserName);

        /* Элекстронная почта */
        final EditText editEmail = findViewById(R.id.editEmail);

        /* Примечание */
        final TextView textNote = findViewById(R.id.textNote);

        /* "OK": сообщение об успешной регистрации или о незаполненных полях */
        final Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Подписка на рассылку успешно оформлена для пользователя %s " +
                        "на электронный адрес %s";
                String userName = editUserName.getText().toString();
                String email = editEmail.getText().toString();

                if(userName.isEmpty()) {
                    textNote.setText("Укажите имя пользователя!");
                    return;
                }

                if(email.isEmpty()) {
                    textNote.setText("Укажите адрес электронной почты!");
                    return;
                }

                textNote.setText(String.format(message, userName, email));
            }
        });

        /* "Очистить": очистка полей ввода и текстового сообщения */
        final Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUserName.setText("");
                editEmail.setText("");
                textNote.setText("");
            }
        });
    }
}
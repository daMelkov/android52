package ru.startandroid.develop.melkovhw52;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import ru.startandroid.develop.melkovhw52.data.Pressure;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        /* Systolic pressure */
        final EditText edtSystolic = findViewById(R.id.edtSystolic);

        /* Diastolic pressure */
        final EditText edtDiastolic = findViewById(R.id.edtDiastolic);

        /* Pulse */
        final EditText edtPulse = findViewById(R.id.edtPulse);

        /* Tachycardia */
        final Switch swTachycardia = findViewById(R.id.swTachycardia);

        /* Date */
        final Calendar calendar = Calendar.getInstance();
        final Button edtDate = findViewById(R.id.btnDatePressure);
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PressureActivity.this, mDateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
            }

            DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    edtDate.setText(DateUtils.formatDateTime(
                            PressureActivity.this,
                            calendar.getTimeInMillis(),
                            DateUtils.FORMAT_SHOW_DATE  | DateUtils.FORMAT_SHOW_YEAR)
                    );
                }
            };
        });

        /* Time */
        final Button edtTime = findViewById(R.id.btnTimePressure);
        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(PressureActivity.this, mTimeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), true)
                        .show();
            }

            TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);

                    edtTime.setText(DateUtils.formatDateTime(
                            PressureActivity.this,
                            calendar.getTimeInMillis(),
                            DateUtils.FORMAT_SHOW_TIME));
                }
            };
        });

        /* Save */
        Button btnSave = findViewById(R.id.btnSavePressure);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int systolic = Integer.parseInt(String.valueOf(edtSystolic.getText()));
                    if (systolic < 50 || systolic > 200) {
                        Toast.makeText(PressureActivity.this, "Верхнее давление должно быть в диапазоне 50...200!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int diastolic = Integer.parseInt(String.valueOf(edtDiastolic.getText()));
                    if (diastolic < 50 || diastolic > 200) {
                        Toast.makeText(PressureActivity.this, "Нижнее давление должно быть в диапазоне 50...200!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int pulse = Integer.parseInt(String.valueOf(edtPulse.getText()));
                    if (pulse < 0 || pulse > 200) {
                        Toast.makeText(PressureActivity.this, "Пульс должен быть в диапазоне 0...200!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    boolean tachycardia = swTachycardia.isChecked();

                    String date = String.valueOf(edtDate.getText()) + " " + String.valueOf(edtTime.getText());

                    Pressure pressure = new Pressure(systolic, diastolic, pulse, tachycardia, date);
                    Log.i(TAG, pressure.toString());
                } catch(Exception e) {
                    Toast.makeText(PressureActivity.this, "Необходимо заполнить все поля!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
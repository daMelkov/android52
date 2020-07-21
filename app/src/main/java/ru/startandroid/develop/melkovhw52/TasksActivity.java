package ru.startandroid.develop.melkovhw52;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class TasksActivity extends AppCompatActivity {
    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndDateCalendar;
    private Button mBtnOK;

    private long mStartDate;
    private long mEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        initViews();
    }
    private void initViews() {

        /* Start date selector */
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndDateCalendar.setVisibility(View.GONE);
            }
        });

        /* End date selector */
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDateCalendar.setVisibility(View.GONE);
                mEndDateCalendar.setVisibility(View.VISIBLE);
            }
        });

        /* Start date calendar */
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                @SuppressLint("DefaultLocale")
                String message = String.format("%s %s.%s.%s",
                        getString(R.string.start_date),
                        dayOfMonth,
                        ("0" + month).substring(("0" + month).length() - 2), // always 2 letters in month: dd.06.yyyy
                        year);

                mChooseStartDate.setText(message);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        /* End date calendar */
        mEndDateCalendar = findViewById(R.id.endDateCalendar);
        mEndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                @SuppressLint("DefaultLocale")
                String message = String.format("%s %s.%s.%s",
                        getString(R.string.end_date),
                        dayOfMonth,
                        ("0" + month).substring(("0" + month).length() - 2), // always 2 letters in month: dd.06.yyyy
                        year);

                mChooseEndDate.setText(message);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });


        mBtnOK = findViewById(R.id.btnOK);
        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStartDate == 0 || mEndDate == 0) {
                    /* error: empty dates */
                    Toast.makeText(TasksActivity.this,
                            getString(R.string.error_empty_date),
                            Toast.LENGTH_SHORT).show();
                }
                else if (mStartDate > mEndDate){
                    /* error: start > end */
                    Toast.makeText(TasksActivity.this,
                            getString(R.string.error_start_end_date),
                            Toast.LENGTH_LONG).show();

                    /* clear choose-widgets */
                    mChooseStartDate.setText(getString(R.string.start_date));
                    mChooseEndDate.setText(getString(R.string.end_date));
                } else {
                    /* all ok */
                    String message = String.format("%s\n%s",
                            mChooseStartDate.getText().toString(),
                            mChooseEndDate.getText().toString());

                    Toast.makeText(TasksActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });

        // Скроем календари при запуске приложения
        mStartDateCalendar.setVisibility(View.GONE);
        mEndDateCalendar.setVisibility(View.GONE);
    }
}
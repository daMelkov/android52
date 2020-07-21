package ru.startandroid.develop.melkovhw52.data;

import android.annotation.SuppressLint;

public class Pressure {
    private int systolic;
    private int diastolic;
    private int pulse;
    private boolean tachycardia;
    private String date;

    public Pressure(int systolic, int diastolic, int pulse, boolean tachycardia, String date) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("Давление: %d/%d, пульс: %d, тахикардия: %s, дата проверки: %s",
                systolic, diastolic, pulse, tachycardia, date);
    }
}

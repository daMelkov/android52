package ru.startandroid.develop.melkovhw52.data;

import android.annotation.SuppressLint;

public class LifeValues {
    double weight;
    int stepCount;

    public LifeValues(double weight, int stepCount) {
        this.weight = weight;
        this.stepCount = stepCount;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("Вес: %f, Количество шагов: %d", weight, stepCount);
    }
}
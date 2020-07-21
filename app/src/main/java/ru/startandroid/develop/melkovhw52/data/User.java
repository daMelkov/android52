package ru.startandroid.develop.melkovhw52.data;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private String name;
    private int age;

    private final Collection<Pressure> pressures;
    private final Collection<LifeValues> lifeValues;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
        this.name = "";
        this.age = 0;
        this.pressures = new ArrayList<>();
        this.lifeValues = new ArrayList<>();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("name: %s, age: %d", name, age);
    }
}

package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private List<Exercise> exercises;
    private static final Global singleton = new Global();

    private Global() {
        exercises = new ArrayList<>();
    }

    public static Global getInstance() {
        return singleton;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }


}

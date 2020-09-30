package com.example.myapplication.logic;

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

    public List<Exercise> renewExercises(int difficulty) {
        this.exercises = new ArrayList<>();
        if (difficulty == 0) {
            //arvotaan

        } else if (difficulty == 1) {

        } else {

        }
        return exercises;
    }
}


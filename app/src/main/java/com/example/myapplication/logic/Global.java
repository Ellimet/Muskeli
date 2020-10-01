package com.example.myapplication.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Global {

    public Random rng;

    private Exercise[] exercises;
    private int difficulty;

    private static final Global singleton = new Global();

    private Global() {
        rng = new Random(1337);
    }

    public static Global getInstance() {
        return singleton;
    }

    public Exercise[] getExercises() {
        return exercises;
    }

    public Exercise[] setExercises(Exercise[] e) {
        this.exercises = e;
    }
    public int getDifficulty() {
        return this.difficulty;
    }

    public Exercise[] renewExercises() {
        this.exercises = ExerciseData.easy;
        if (difficulty == 0) {
            //arvotaan

        } else if (difficulty == 1) {

        } else {

        }
        return exercises;
    }
    public Exercise[] renewExercise(int index) {
        int harjoitus = rng.nextInt(6);
        this.exercises[index] = getExercisesByDifficulty()[harjoitus];
        return this.exercises;
    }

    private Exercise[] getExercisesByDifficulty() {
        return this.difficulty == 0 ? ExerciseData.easy :  this.difficulty == 1 ? ExerciseData.medium : ExerciseData.hard;
    }
}


package com.example.myapplication.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Global {

    public Random rng;
    private int difficulty;
    private Exercise[] exercises;
    private static final Global singleton = new Global(); //luokka luodaan ohjelman kännistyessä

    private Global() {
        rng = new Random(1337);
    }

    //Pääsy tähän luokkaan
    public static Global getInstance() {
        return singleton;
    }

    public int getDifficulty() {
        return this.difficulty;
    }
    public Exercise[] getExercises() {
        return exercises;
    }

    //set specific difficulty, on startup.
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    //set specific exercises, on startup.
    public void setExercises(Exercise[] e) {
        this.exercises = e;
    }

    //Sufflaa uudet harjoitukset. Koska haluamme käyttää Elmon suositusta, Shufflea, pitää tehdä pari tyyppimuunnosta :(
    public Exercise[] renewExercises() {
        List<Exercise> newExercises = Arrays.asList(getExercisesByDifficulty()); //Exercise[] to List<Exercise>
        Collections.shuffle(newExercises);  //SHUFFLE!
        return (Exercise[]) newExercises.toArray(); //List<Exercise> to Exercise[]
    }
    //Arpoo yhden uuden harjoituksen.
    public Exercise[] renewExercise(int index) {
        int harjoitus = rng.nextInt(6);
        this.exercises[index] = getExercisesByDifficulty()[harjoitus];
        return this.exercises;
    }

    private Exercise[] getExercisesByDifficulty() {
        return this.difficulty == 0 ? ExerciseData.easy :  this.difficulty == 1 ? ExerciseData.medium : ExerciseData.hard;
    }
}


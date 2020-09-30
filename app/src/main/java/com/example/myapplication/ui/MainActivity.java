package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.logic.Exercise;
import com.example.myapplication.logic.ExerciseData;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Muskeli.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lmao", "Started.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("MainPrefs", Context.MODE_PRIVATE);
        //creations = prefs.getInt("creations", 0);

        for(Exercise e: Exercise.values()) {
            Log.d("lmao",  e.ordinal() + " " + e.toString() + " => " + ExerciseData.names[e.ordinal()]);
        }

    }

    public void setActivity(View view) {
        Class c;
        if (view == findViewById(R.id.buttonProgress))      c = ProgressActivity.class;
        else if(view == findViewById(R.id.buttonExercise))  c = ExerciseActivity.class;
        else if(view == findViewById(R.id.buttonGoal))      c = GoalActivity.class;
        else return;

        Intent intent = new Intent(this, c);
        intent.putExtra(EXTRA_MESSAGE, "Viesti toiselle activitylle");
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor e = getSharedPreferences("MainPrefs", Context.MODE_PRIVATE).edit();
        //e.putInt("creations", creations);
        e.apply();
    }


}
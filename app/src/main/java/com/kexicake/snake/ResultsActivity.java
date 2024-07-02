package com.kexicake.snake;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;


import java.util.Map;

public class ResultsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView resultsTextView = new TextView(this);
        setContentView(resultsTextView);

        SharedPreferences prefs = getSharedPreferences("snake_scores", MODE_PRIVATE);
        Map<String, ?> allEntries = prefs.getAll();

        StringBuilder results = new StringBuilder("Результаты:\n");
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            results.append(entry.getKey()).append(": ").append(entry.getValue().toString()).append("\n");
        }

        resultsTextView.setText(results.toString());
    }
    public static void saveStore(Context context, long score, String nickname) {
        // Save the score to the database using nickname
        // For simplicity, using SharedPreferences in this example
        SharedPreferences prefs = context.getSharedPreferences("snake_scores", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(nickname, score);
        editor.apply();
    }
}

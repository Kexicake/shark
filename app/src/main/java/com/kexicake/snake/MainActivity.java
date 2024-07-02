package com.kexicake.snake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nicknameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicknameEditText = findViewById(R.id.nickname);

        Button startGameButton = findViewById(R.id.start_game);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = nicknameEditText.getText().toString().trim();
                if (nickname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Пожалуйста, введите ник", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Snake.class);
                    intent.putExtra("nickname", nickname);
                    startActivity(intent);
                }
            }
        });

        Button viewResultsButton = findViewById(R.id.view_results);
        viewResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
        });
    }
}

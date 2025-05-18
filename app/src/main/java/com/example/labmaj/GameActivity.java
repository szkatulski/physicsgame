package com.example.labmaj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends Activity {
    private GameView gameView;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameView = findViewById(R.id.game_view);
        Button pauseButton = findViewById(R.id.button_pause);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused) {
                    gameView.resumeGame();
                    pauseButton.setText("Pause");
                } else {
                    gameView.pauseGame();
                    pauseButton.setText("Resume");
                }
                isPaused = !isPaused;
            }
        });
    }
}
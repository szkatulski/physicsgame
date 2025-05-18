package com.example.labmaj;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Thread thread;
    private boolean running = false;
    private float ballX, ballY, ballRadius = 50;
    private float velocityY = 0, velocityX = 0;
    private final float gravity = 0.7f;
    private final float airResistance = 0.99f;
    private final float bounceLoss = 0.8f;
    private Paint paint = new Paint();
    private SoundPool soundPool;
    private int bounceSound;
    private SharedPreferences prefs;
    private boolean paused = false;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        paint.setColor(Color.BLUE);
        setFocusable(true);
        soundPool = new SoundPool.Builder().setMaxStreams(1).build();
        bounceSound = soundPool.load(context, R.raw.bounce, 1);
        prefs = context.getSharedPreferences("game", Context.MODE_PRIVATE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        ballX = prefs.getFloat("ballX", getWidth() / 2f);
        ballY = prefs.getFloat("ballY", getHeight() / 2f);
        velocityX = prefs.getFloat("velocityX", 0);
        velocityY = prefs.getFloat("velocityY", 0);
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        running = false;
        try { thread.join(); } catch (InterruptedException ignored) {}
        // Save state
        prefs.edit()
            .putFloat("ballX", ballX)
            .putFloat("ballY", ballY)
            .putFloat("velocityX", velocityX)
            .putFloat("velocityY", velocityY)
            .apply();
    }

    @Override
    public void run() {
        while (running) {
            if (!getHolder().getSurface().isValid()) continue;
            updatePhysics();
            Canvas canvas = getHolder().lockCanvas();
            if (canvas != null) {
                drawGame(canvas);
                getHolder().unlockCanvasAndPost(canvas);
            }
            try { Thread.sleep(16); } catch (InterruptedException ignored) {}
        }
    }

    public void pauseGame() {
        paused = true;
    }

    public void resumeGame() {
        paused = false;
    }

    private void updatePhysics() {
        if (paused) return;
        velocityY += gravity;
        velocityY *= airResistance;
        velocityX *= airResistance;
        ballX += velocityX;
        ballY += velocityY;

        // Odbicie od dołu
        if (ballY + ballRadius > getHeight()) {
            ballY = getHeight() - ballRadius;
            velocityY = -velocityY * bounceLoss;
            soundPool.play(bounceSound, 1, 1, 0, 0, 1);
        }
        // Odbicie od boków
        if (ballX - ballRadius < 0) {
            ballX = ballRadius;
            velocityX = -velocityX * bounceLoss;
        }
        if (ballX + ballRadius > getWidth()) {
            ballX = getWidth() - ballRadius;
            velocityX = -velocityX * bounceLoss;
        }
    }

    private void drawGame(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(ballX, ballY, ballRadius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            velocityY = -20;
            velocityX = (float) ((Math.random() - 0.5) * 20);
        }
        return true;
    }

    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
}
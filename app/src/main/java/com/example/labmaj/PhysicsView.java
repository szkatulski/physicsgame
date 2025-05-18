package com.example.labmaj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PhysicsView extends View {
    private Paint paint;
    private float objectY;
    private float velocity;
    private float gravity = 0.5f;

    public PhysicsView(Context context) {
        super(context);
        paint = new Paint();
        objectY = 0;
        velocity = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(0xFF0000FF); // Blue color
        canvas.drawCircle(getWidth() / 2, objectY, 50, paint);
        updatePhysics();
        invalidate();
    }

    private void updatePhysics() {
        velocity += gravity;
        objectY += velocity;
        if (objectY > getHeight()) {
            objectY = getHeight();
            velocity = -velocity * 0.8f; // Bounce effect
        }
    }
}
package com.link.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Timer timer;
    Canvas canvas, canvas1, canvas2, canvas3, canvas4;
    Paint paint, paint1, paint2, paint3, paint4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = Bitmap.createBitmap(1000, 1500, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas1 = new Canvas(bitmap);
        canvas2 = new Canvas(bitmap);
        canvas3 = new Canvas(bitmap);
        canvas4 = new Canvas(bitmap);


        paint = new Paint();
        paint.setColor(Color.YELLOW);

        paint1 = new Paint();
        paint1.setColor(Color.GRAY);
        paint1.setStrokeWidth(10f);
        paint1.setStyle(Paint.Style.STROKE);

        paint2 = new Paint();
        paint2.setColor(Color.GRAY);
        paint2.setStrokeWidth(10f);
        paint2.setStyle(Paint.Style.STROKE);

        paint3 = new Paint();
        paint3.setColor(Color.GRAY);
        paint3.setStrokeWidth(10f);
        paint3.setStyle(Paint.Style.STROKE);

        paint4 = new Paint();
        paint4.setColor(Color.GRAY);
        paint4.setStrokeWidth(10f);
        paint4.setStyle(Paint.Style.STROKE);


        canvas.drawCircle(500f, 500f, 150f, paint);
        canvas1.drawCircle(400f, 560f, 48, paint1);
        canvas2.drawCircle(750f, 920f, 48, paint2);
        canvas3.drawCircle(300f, 1100f, 48, paint3);
        canvas4.drawCircle(320f, 300f, 48, paint4);


        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                animationFrame();

                            }
                        }
                );
            }
        }, 0, 200);


    }

    private void animationFrame() {

        canvas.drawColor(Color.parseColor("#EBEBEB"));
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(500f, 750f, 150f, paint);


        if (paint1 != null | paint3 != null) {
            canvas1.rotate(10f, 500f, 750f);
            paint.setColor(Color.GRAY);
            paint.setStyle(Paint.Style.STROKE);
            canvas1.drawCircle(400f, 560f, 48f, paint1);

            canvas2.rotate(30f, 500f, 750f);
            paint.setColor(Color.GRAY);
            paint.setStyle(Paint.Style.STROKE);
            canvas2.drawCircle(750f, 920f, 45f, paint2);
        }
        if (paint2 != null | paint4 != null) {
            canvas3.rotate(-10f, 500f, 750f);
            paint.setColor(Color.GRAY);
            paint.setStyle(Paint.Style.STROKE);
            canvas3.drawCircle(300f, 1100f, 48, paint3);

            canvas4.rotate(-25f, 500f, 750f);
            paint.setColor(Color.GRAY);
            paint.setStyle(Paint.Style.STROKE);
            canvas4.drawCircle(320f, 300f, 42, paint4);
        }

        imageView.invalidate();
    }
    }

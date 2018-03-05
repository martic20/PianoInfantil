package martic20.pianoinfantil;

import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imatge1;
    private ImageView imatge2;
    private ImageView imatge3;

    MediaPlayer so;
    MediaController controls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imatge1 = (ImageView) findViewById(R.id.imageView);
        imatge2 = (ImageView) findViewById(R.id.imageView1);
        imatge3 = (ImageView) findViewById(R.id.imageView2);
        so = MediaPlayer.create(getApplicationContext(), R.raw.s1);

        stopAnimations();

        imatge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimations();
                so = MediaPlayer.create(getApplicationContext(), R.raw.s1);
                so.setLooping(true);
                so.start();
                AnimationDrawable animacio = (AnimationDrawable) imatge1.getDrawable();
                animacio.start();
            }
        });
        imatge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimations();
                so = MediaPlayer.create(getApplicationContext(), R.raw.s2);
                so.setLooping(true);
                so.start();
                AnimationDrawable animacio = (AnimationDrawable) imatge2.getDrawable();
                animacio.start();
            }
        });
        imatge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimations();
                so = MediaPlayer.create(getApplicationContext(), R.raw.s3);
                so.setLooping(true);
                so.start();
                AnimationDrawable animacio = (AnimationDrawable) imatge3.getDrawable();
                animacio.start();
            }
        });


    }

    public void stopAnimations() {
        imatge1.setImageResource(R.drawable.spidey);
        imatge2.setImageResource(R.drawable.walker);
        imatge3.setImageResource(R.drawable.runner);
        so.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        so.stop();
    }
}

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

public class MainActivity extends AppCompatActivity implements MediaController.MediaPlayerControl {

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

    // Mètodes de l'activitat
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        controls.show();
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        so.stop();
        so.release();
    }

    @Override
    public void start() {
        so.start();
    }

    @Override
    public void pause() {
        // Quan l'usuari toca el botó de pausa
        so.pause();
    }

    @Override
    public int getDuration() {
        // Torna la durada de la pista d'audio
        return so.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        // Torna la posició actual a la pista d'audio
        return so.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        // Per anar a una posició de la pista
        so.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        // Torna cert quan s'està reproduint audio
        return so.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

}

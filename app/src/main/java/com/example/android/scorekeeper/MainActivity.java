package com.example.android.scorekeeper;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {

    MediaPlayer mediaPlayerWallpaper;
    Boolean audioStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextureView textureViewWallpaper;
        AlertDialog easterEgg;

        textureViewWallpaper = (TextureView) findViewById(R.id.texture_wallpaper);
        textureViewWallpaper.setSurfaceTextureListener(this);

        easterEgg = new AlertDialog.Builder(this)
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setIcon(R.drawable.ic_warning_black_18dp).
                        setPositiveButton(R.string.accept_button_text,null).create();

        easterEgg.show();

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        Surface surface;
        surface = new Surface(surfaceTexture);
        mediaPlayerWallpaper = MediaPlayer.create(getBaseContext(), R.raw.texture_wallpaper_overwatch);
        mediaPlayerWallpaper.setLooping(true);
        mediaPlayerWallpaper.setSurface(surface);
        mediaPlayerWallpaper.setVolume(0, 0);
        audioStat = false;
        mediaPlayerWallpaper.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayerWallpaper.start();
            }
        });
    }

    public void increaseByOneTeamA(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamAScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 1));
    }

    public void increaseByTwoTeamA(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamAScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 2));
    }

    public void increaseByThreeTeamA(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamAScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 3));
    }

    public void increaseByOneTeamB(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamBScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 1));
    }

    public void increaseByTwoTeamB(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamBScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 2));
    }

    public void increaseByThreeTeamB(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamBScore);
        textViewCurrentScore.setText(addToScore(textViewCurrentScore, 3));
    }

    private String addToScore(TextView textView, int toAdd) {
        return String.valueOf(
                Integer.parseInt(textView.getText().toString()) + toAdd);
    }

    public void resetScore(View view) {
        TextView textViewCurrentScore;

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamAScore);
        textViewCurrentScore.setText("0");

        textViewCurrentScore = (TextView) findViewById(R.id.textViewTeamBScore);
        textViewCurrentScore.setText("0");
    }

    public void turnAudio(View view) {
        if (audioStat) {
            mediaPlayerWallpaper.setVolume(0, 0);
            audioStat = false;
        } else {
            mediaPlayerWallpaper.setVolume(1, 1);
            audioStat = true;
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }
}

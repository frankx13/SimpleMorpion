package com.studio.neopanda.simplemorpion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final int MIN_TAILLE = 10;
    private SeekBar choixTaille;
    private TextView tvTaille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTaille = findViewById(R.id.taille);
        choixTaille = findViewById(R.id.choixTaille);
        Button startBtn = findViewById(R.id.startBtn);

        tvTaille.setText((10 + MIN_TAILLE) + "x" + (10 + MIN_TAILLE));
        choixTaille.setProgress(10);

        choixTaille.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvTaille.setText((MIN_TAILLE + i) + "x" + (MIN_TAILLE + i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = choixTaille.getProgress() + MIN_TAILLE;
                go(val);
            }
        });
    }


    public void go(int taille) {
        Intent caller = new Intent(this, PlayActivity.class);
        caller.putExtra(PlayActivity.EXTRA_SIZE, taille);
        startActivity(caller);
    }
}
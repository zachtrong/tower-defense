package com.uet.towerdefense;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_start)
    Button startButton;
    @BindView(R.id.btn_high_score)
    Button highScoreButton;
    @BindView(R.id.btn_guide)
    Button guideButton;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupListener() {
        startButton.setOnClickListener(view -> {
            Toast.makeText(this, "this is a dummy toast", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, GamePlayActivity.class));
        });
        highScoreButton.setOnClickListener(view -> {
            startActivity(new Intent(this, HighScoreActivity.class));
        });
        guideButton.setOnClickListener(view ->{

            startActivity(new Intent(this, GuideActivity.class));
        });
    }

    @Override
    protected void populateData() {
    }
}


package com.uet.towerdefense;

import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.widget.Button;

import butterknife.BindView;

import static com.uet.towerdefense.Constants.SCREEN_HEIGHT;
import static com.uet.towerdefense.Constants.SCREEN_WIDTH;

public class GameStageActivity extends BaseActivity {

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
    startButton.setOnClickListener(
        view -> {
          startActivity(new Intent(this, CustomGameFieldActivity.class));
        });
    highScoreButton.setOnClickListener(
        view -> {
          startActivity(new Intent(this, HighScoreActivity.class));
        });
    guideButton.setOnClickListener(
         view -> {
          startActivity(new Intent(this, GuideActivity.class));
        });

  }

  @Override
  protected void populateData() {}
}

package com.uet.towerdefense;

import android.content.Intent;
import android.widget.Button;

import butterknife.BindView;

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
          startActivity(new Intent(this, GameFieldActivity.class));
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

package com.uet.towerdefense;

import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.widget.Button;

import butterknife.BindView;

import static com.uet.towerdefense.Constants.GET_HEIGHT;
import static com.uet.towerdefense.Constants.GET_WIDTH;

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

      Display display = getWindowManager().getDefaultDisplay();
      Point size = new Point();
      display.getSize(size);
      GET_WIDTH = size.x;
      GET_HEIGHT = size.y;

    startButton.setOnClickListener(
        view -> {
          startActivity(new Intent(this, GameFieldActivity.class));
        });
    highScoreButton.setOnClickListener(
        view -> {
          startActivity(new Intent(this, CustomGameFieldActivity.class));
        });
    guideButton.setOnClickListener(
         view -> {
          startActivity(new Intent(this, GuideActivity.class));
        });

  }

  @Override
  protected void populateData() {}
}

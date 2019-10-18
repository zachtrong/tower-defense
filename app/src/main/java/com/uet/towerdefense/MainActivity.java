package com.uet.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

  @BindView(R.id.btn_start)
  Button startButton;
  @BindView(R.id.btn_high_score)
  Button highScoreButton;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_main;
  }

  @Override
  protected void setupListener() {
    startButton.setOnClickListener(view -> {
      startActivity(new Intent(this, GamePlayActivity.class));
    });
    highScoreButton.setOnClickListener(view -> {
      startActivity(new Intent(this, HighScoreActivity.class));
    });
  }

  @Override
  protected void populateData() {
  }
}

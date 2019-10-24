package com.uet.towerdefense;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;

public class GamePlayActivity extends BaseActivity {
  @BindView(R.id.tv_score_number)
  TextView scoreNumber;

  @BindView(R.id.btn_increase)
  Button increaseButton;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_gameplay;
  }

  @Override
  protected void setupListener() {
    increaseButton.setOnClickListener(
        view -> {
          int score = Integer.parseInt(scoreNumber.getText().toString());
          score = score + 1;
          getSharedPreferences().edit().putInt(getString(R.string.pref_score), score).apply();
          scoreNumber.setText(String.valueOf(score));
        });
  }

  @Override
  protected void populateData() {
    int score = getSharedPreferences().getInt(getString(R.string.pref_score), 0);
    scoreNumber.setText(String.valueOf(score));
  }
}

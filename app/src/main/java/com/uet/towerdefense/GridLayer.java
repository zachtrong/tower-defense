package com.uet.towerdefense;

import android.os.CountDownTimer;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.uet.towerdefense.enemy.Enemy;

import butterknife.BindView;

public class GridLayer {
  public static final int OBJECT_SIZE = 10;
  private int deviceWidth, deviceHeight;
  private int gameTotalRows, gameTotalColumns;
  private FrameLayout parent;

  GridLayer(FrameLayout parent) {
    this.parent = parent;
    this.deviceWidth = parent.getWidth();
    this.deviceHeight = parent.getHeight();

    gameTotalRows = deviceWidth / OBJECT_SIZE;
    gameTotalColumns = deviceHeight / OBJECT_SIZE;
  }

  void addEnemy(Enemy enemy) {
    parent.addView(enemy.getView());
    enemy.setX(0);
    enemy.setY(gameTotalRows / 2 * OBJECT_SIZE);
    enemy.applyMove();
  }

  public void moveEnemy(Enemy enemy) {
    CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {
      @Override
      public void onTick(long millisUntilFinished) {
        enemy.moveRight();
        enemy.moveDown();


      }

      @Override
      public void onFinish() {
      }
    };
    countDownTimer.start();
  }
}

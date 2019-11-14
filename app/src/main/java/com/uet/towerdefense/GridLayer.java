package com.uet.towerdefense;


import android.os.CountDownTimer;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.uet.towerdefense.enemy.Enemy;

import butterknife.BindView;

import static com.uet.towerdefense.Constants.GET_HEIGHT;
import static com.uet.towerdefense.Constants.GET_WIDTH;
import static com.uet.towerdefense.Constants.getdown;
import static com.uet.towerdefense.Constants.getright;

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
    enemy.setX((int) (0));
    enemy.setY((int) (0.2681*GET_WIDTH));
    enemy.applyMove();
  }

  public void moveEnemy(Enemy enemy) {

    CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {
      @Override
      public void onTick(long millisUntilFinished) {
        if(enemy.getX()<0.1828*GET_HEIGHT){
          enemy.moveRight();
        }

        if(enemy.getX()>=0.1828*GET_HEIGHT-2&&enemy.getX()<=0.1829*GET_HEIGHT+2)
        {
          if(enemy.getY()<0.8055*GET_WIDTH)
          {
            enemy.moveDown();
          }
        }

        if(enemy.getY()>=0.8055*GET_WIDTH-2&&enemy.getY()<=0.8056*GET_WIDTH+2)
        {
          if(enemy.getX()<0.332*GET_HEIGHT)
          {
            enemy.moveRight();
          }
        }

        if(enemy.getX()>=0.332*GET_HEIGHT-2&&enemy.getX()<=0.333*GET_HEIGHT+2)
        {
            if(enemy.getY()>0.0694*GET_WIDTH)
            {
              enemy.moveUp();
            }
        }

        if(enemy.getY()>=0.0694*GET_WIDTH-2&&enemy.getY()<=0.0695*GET_WIDTH+2)
        {
          if(enemy.getX()<0.8476*GET_HEIGHT)
          {
            enemy.moveRight();
          }
        }

        if(enemy.getX()>=0.8476*GET_HEIGHT-2&&enemy.getX()<=0.8476*GET_HEIGHT+2)
        {
          if(enemy.getY()<0.3819*GET_WIDTH)
          {
            enemy.moveDown();
          }
        }

        if(enemy.getY()>=0.3819*GET_WIDTH-2&&enemy.getY()<=0.3819*GET_WIDTH+2)
        {
          if(enemy.getX()<=GET_HEIGHT&&enemy.getX()>=0.8476*GET_HEIGHT)
          {
            enemy.moveRight();
          }
        }

        if(enemy.getX()>=GET_HEIGHT-1)
        {
          cancel();
        }
        getright=enemy.getX();
        getdown=enemy.getY();
        Log.e("Width", "" + getright);
        Log.e("height", "" + getdown);


      }

      @Override
      public void onFinish() {
      }
    };
    countDownTimer.start();
  }
}

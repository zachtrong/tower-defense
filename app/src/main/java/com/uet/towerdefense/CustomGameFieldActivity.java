package com.uet.towerdefense;


import android.graphics.Point;
import android.util.Log;

import android.view.Display;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.NormalEnemy;


import static com.uet.towerdefense.Constants.GET_WIDTH;
import static com.uet.towerdefense.Constants.GET_HEIGHT;
import static com.uet.towerdefense.Constants.getdown;
import static com.uet.towerdefense.Constants.getright;

import butterknife.BindView;

public class CustomGameFieldActivity extends BaseActivity {

  @BindView(R.id.fl_game_field)
  FrameLayout gameFieldLayout;
  @BindView(R.id.textView)
  TextView toaDoX;
  @BindView(R.id.textView2)
  TextView toaDoY;
  private GridLayer gridLayer;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_custom_game_field;
  }

  @Override
  protected void setupListener() {

//    Display display = getWindowManager().getDefaultDisplay();
//    Point size = new Point();
//    display.getSize(size);
//    GET_WIDTH = size.x;
//    GET_HEIGHT = size.y;
//    Log.e("Width", "" + GET_WIDTH);
//    Log.e("height", "" + GET_HEIGHT);

    gridLayer = new GridLayer(gameFieldLayout);
    Enemy enemy = new NormalEnemy(gameFieldLayout);
    gridLayer.addEnemy(enemy);
    gridLayer.moveEnemy(enemy);
    toaDoX.setText(String.valueOf(GET_WIDTH));
    toaDoY.setText(String.valueOf(GET_HEIGHT));

  }

  @Override
  protected void populateData() {}
}

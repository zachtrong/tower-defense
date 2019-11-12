package com.uet.towerdefense;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.NormalEnemy;

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

    gridLayer = new GridLayer(gameFieldLayout);
    Enemy enemy = new NormalEnemy(gameFieldLayout);
    gridLayer.addEnemy(enemy);
    gridLayer.moveEnemy(enemy);
    toaDoX.setText(String.valueOf(gameFieldLayout.getWidth()));
    toaDoY.setText(String.valueOf(gameFieldLayout.getHeight()));
  }

  @Override
  protected void populateData() {}
}

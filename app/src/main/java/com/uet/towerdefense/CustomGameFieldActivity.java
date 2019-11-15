package com.uet.towerdefense;


import android.widget.FrameLayout;

import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.EnemyDirection;
import com.uet.towerdefense.enemy.NormalEnemy;
import com.uet.towerdefense.tile.Road;


import butterknife.BindView;

public class CustomGameFieldActivity extends BaseActivity {

  @BindView(R.id.fl_game_field)
  FrameLayout gameFieldLayout;

  private GridLayer gridLayer;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_custom_game_field;
  }

  @Override
  protected void setupListener() {
  }

  @Override
  protected void populateData() {
    gridLayer = new GridLayer(gameFieldLayout);
    addEnemy();
  }

  private void addEnemy() {
    Enemy enemy = new NormalEnemy(gameFieldLayout);
    gridLayer.addEnemy(enemy);
    gridLayer.moveEnemyWithDirectionStart(enemy);
  }
}

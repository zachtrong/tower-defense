package com.uet.towerdefense;


import android.content.Intent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.util.Consumer;

import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.EnemyDirection;
import com.uet.towerdefense.enemy.NormalEnemy;
import com.uet.towerdefense.tile.Road;
import com.uet.towerdefense.tower.Tower;


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

  private Consumer<Tower> callbackTower =
      tower -> {
        Toast.makeText(this, "BUY TOWER", Toast.LENGTH_SHORT).show();
      };

  @Override
  protected void populateData() {
    gridLayer = new GridLayer(gameFieldLayout, callbackTower);
    addEnemy();
  }

  private void addEnemy() {
    Enemy enemy = new NormalEnemy(gameFieldLayout);
    gridLayer.addEnemy(enemy);
    gridLayer.moveEnemyWithDirectionStart(enemy);
  }
}

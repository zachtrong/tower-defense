package com.uet.towerdefense;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.util.Consumer;

import com.uet.towerdefense.bullet.Bullet;
import com.uet.towerdefense.enemy.BossEnemy;
import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.EnemyDirection;
import com.uet.towerdefense.enemy.NormalEnemy;
import com.uet.towerdefense.enemy.SmallerEnemy;
import com.uet.towerdefense.enemy.TankerEnemy;
import com.uet.towerdefense.tile.Road;
import com.uet.towerdefense.tower.MachineGunTower;
import com.uet.towerdefense.tower.NormalTower;
import com.uet.towerdefense.tower.PlaceholderTower;
import com.uet.towerdefense.tower.SniperTower;
import com.uet.towerdefense.tower.Tower;
import com.uet.towerdefense.util.Point;

import java.util.Random;

import javax.net.ssl.HandshakeCompletedListener;

import butterknife.BindView;

import static com.uet.towerdefense.BuyTowerActivity.RESULT_MACHINEGUN;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_NORMALTOWE;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_SNIPER;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_TOWERNULL;

public class CustomGameFieldActivity extends BaseActivity {
  public static Point point;
  public static int returnData;

  @BindView(R.id.fl_game_field)
  FrameLayout gameFieldLayout;

  private GridLayer gridLayer;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_custom_game_field;
  }

  @Override
  protected void setupListener() {}

  private Consumer<Tower> callbackTower =
      tower -> {
        point = tower.getPosition();
        gameFieldLayout.removeView(tower.getView());
        buyTower();
      };

  @Override
  protected void populateData() {
    gridLayer = new GridLayer(gameFieldLayout, callbackTower);
    spawnEnemy();
  }

  private void spawnEnemy() {
    final Handler handler = new Handler(Looper.getMainLooper());
    handler.postDelayed(
        () -> {
          addEnemy();
          spawnEnemy();
        },
        2000);
  }

  private void addEnemy() {
    Enemy enemy;
    int type = new Random().nextInt(3);
    switch (type) {
      case 0:
        enemy = new SmallerEnemy(gameFieldLayout);
        break;
      case 1:
        enemy = new NormalEnemy(gameFieldLayout);
        break;
      case 2:
        enemy = new TankerEnemy(gameFieldLayout);
        break;
      case 3:
        enemy = new BossEnemy(gameFieldLayout);
        break;
      default:
        enemy = new NormalEnemy(gameFieldLayout);
        break;
    }

    gridLayer.addEnemy(enemy);
    gridLayer.moveEnemyWithDirectionStart(enemy);

  }

  private void buyTower() {
    Intent intent = new Intent();
    intent.setClass(this, BuyTowerActivity.class);
    startActivityForResult(intent, returnData);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == returnData) {
      if (resultCode == RESULT_MACHINEGUN) {

        MachineGunTower machineGunTower = new MachineGunTower(gameFieldLayout);
        machineGunTower.setPosition(point);
        gameFieldLayout.addView(machineGunTower.getView());
        machineGunTower
            .getView()
            .setOnClickListener(
                v -> {
                  point = machineGunTower.getPosition();
                  gameFieldLayout.removeView(machineGunTower.getView());
                  buyTower();
                });
      }
      if (resultCode == RESULT_SNIPER) {

        SniperTower sniperTower = new SniperTower(gameFieldLayout);
        sniperTower.setPosition(point);
        gameFieldLayout.addView(sniperTower.getView());
        sniperTower
            .getView()
            .setOnClickListener(
                v -> {
                  point = sniperTower.getPosition();
                  gameFieldLayout.removeView(sniperTower.getView());
                  buyTower();
                });
      }
      if (resultCode == RESULT_NORMALTOWE) {

        NormalTower normalTower = new NormalTower(gameFieldLayout);
        normalTower.setPosition(point);
        gameFieldLayout.addView(normalTower.getView());
        normalTower
            .getView()
            .setOnClickListener(
                v -> {
                  point = normalTower.getPosition();
                  gameFieldLayout.removeView(normalTower.getView());
                  buyTower();
                });
      }
      if (resultCode == RESULT_TOWERNULL) {
        PlaceholderTower placeholderTower = new PlaceholderTower(gameFieldLayout);
        placeholderTower.setPosition(point);
        gameFieldLayout.addView(placeholderTower.getView());
        placeholderTower
            .getView()
            .setOnClickListener(
                v -> {
                  point = placeholderTower.getPosition();
                  gameFieldLayout.removeView(placeholderTower.getView());
                  buyTower();
                });
        // tăng coin
      }
    }
  }
}

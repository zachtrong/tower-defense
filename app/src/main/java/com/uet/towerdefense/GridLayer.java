package com.uet.towerdefense;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

import androidx.core.util.Consumer;

import com.uet.towerdefense.enemy.Enemy;
import com.uet.towerdefense.enemy.EnemyDirection;
import com.uet.towerdefense.tower.PlaceholderTower;
import com.uet.towerdefense.tower.Tower;
import com.uet.towerdefense.util.Point;


import static com.uet.towerdefense.Constants.SCREEN_HEIGHT;
import static com.uet.towerdefense.Constants.SCREEN_WIDTH;

public class GridLayer {
  private FrameLayout parent;
  private Handler handler = new Handler(Looper.getMainLooper());
  private double per100Width, per100Height;
  private Consumer<Tower> callbackTower;

  GridLayer(FrameLayout parent, Consumer<Tower> callbackTower) {
    this.parent = parent;
    this.callbackTower = callbackTower;

    per100Width = ScreenSizeManager.getInstance().getPer100Width();
    per100Height = ScreenSizeManager.getInstance().getPer100Height();
    setupTower();
  }

  private void setupTower() {
    createPlaceHolderTower(25, 30);
    createPlaceHolderTower(25, 73);
    createPlaceHolderTower(40, 20);
    createPlaceHolderTower(40, 60);
    createPlaceHolderTower(80, 20);
  }

  private void createPlaceHolderTower(int perWidth, int perHeight) {
    PlaceholderTower tower = new PlaceholderTower(parent);
    tower.setPosition(new Point(per100Width * perWidth, per100Height * perHeight));
    parent.addView(tower.getView());
    tower.getView().setOnClickListener(v -> callbackTower.accept(tower));
  }

  void addEnemy(Enemy enemy) {
    parent.addView(enemy.getView());
    enemy.setX(0);
    enemy.setY((int) (30 * per100Height));
    enemy.applyMove();
  }

  public void moveEnemyWithDirectionStart(Enemy enemy) {
    moveEnemyWithDirection(enemy, EnemyDirection.RIGHT);
  }

  public void moveEnemyWithDirection(Enemy enemy, EnemyDirection direction) {
    switch (direction) {
      case UP:
        enemy.moveUp();
        break;
      case DOWN:
        enemy.moveDown();
        break;
      case LEFT:
        enemy.moveLeft();
        break;
      case RIGHT:
        enemy.moveRight();
        break;
    }

    EnemyDirection newDirection = changeEnemyDirection(enemy, direction);
    handler.postDelayed(
        () -> moveEnemyWithDirection(enemy, newDirection), Constants.DEFAULT_DELAY_MS);
  }

  private EnemyDirection changeEnemyDirection(Enemy enemy, EnemyDirection direction) {
    if (enemy.getX() > per100Width * 19 && enemy.getY() < per100Height * 40) {
      if (direction == EnemyDirection.RIGHT) {
        return EnemyDirection.DOWN;
      }
    }
    return direction;
  }

  @Deprecated
  public void moveEnemy(Enemy enemy) {

    moveRightTilPosition(enemy, 0.1828);
    moveDownTilPosition(enemy, 0.1828, 0.1829, 0.8055);

    if (enemy.getY() >= 0.8055 * SCREEN_WIDTH - 2 && enemy.getY() <= 0.8056 * SCREEN_WIDTH + 2) {
      moveRightTilPosition(enemy, 0.332);
    }

    moveUpTilPosition(enemy);

    if (enemy.getY() >= 0.0694 * SCREEN_WIDTH - 2 && enemy.getY() <= 0.0695 * SCREEN_WIDTH + 2) {
      moveRightTilPosition(enemy, 0.8476);
    }

    moveDownTilPosition(enemy, 0.8476, 0.8476, 0.3819);

    moveRightTilPosition(enemy);

    if (enemy.getX() >= SCREEN_HEIGHT - 1) {
      return;
    }

    handler.postDelayed(() -> moveEnemy(enemy), 20);
  }

  private void moveRightTilPosition(Enemy enemy) {
    if (enemy.getY() >= 0.3819 * SCREEN_WIDTH - 2 && enemy.getY() <= 0.3819 * SCREEN_WIDTH + 2) {
      if (enemy.getX() <= SCREEN_HEIGHT && enemy.getX() >= 0.8476 * SCREEN_HEIGHT) {
        enemy.moveRight();
      }
    }
  }

  private void moveUpTilPosition(Enemy enemy) {
    if (enemy.getX() >= 0.332 * SCREEN_HEIGHT - 2 && enemy.getX() <= 0.333 * SCREEN_HEIGHT + 2) {
      if (enemy.getY() > 0.0694 * SCREEN_WIDTH) {
        enemy.moveUp();
      }
    }
  }

  private void moveDownTilPosition(Enemy enemy, double v, double v2, double v3) {
    if (enemy.getX() >= v * SCREEN_HEIGHT - 2 && enemy.getX() <= v2 * SCREEN_HEIGHT + 2) {
      if (enemy.getY() < v3 * SCREEN_WIDTH) {
        enemy.moveDown();
      }
    }
  }

  private void moveRightTilPosition(Enemy enemy, double v) {
    if (enemy.getX() < v * SCREEN_HEIGHT) {
      enemy.moveRight();
    }
  }
}

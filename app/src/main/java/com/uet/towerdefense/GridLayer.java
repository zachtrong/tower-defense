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

import java.util.HashSet;


public class GridLayer {
  private FrameLayout parent;
  private Handler handler = new Handler(Looper.getMainLooper());
  private double per100Width, per100Height;
  private Consumer<Tower> callbackTower;
  private HashSet<Enemy> enemies = new HashSet<>();
  private HashSet<Tower> towers = new HashSet<>();

  GridLayer(FrameLayout parent, Consumer<Tower> callbackTower) {
    this.parent = parent;
    this.callbackTower = callbackTower;

    per100Width = ScreenSizeManager.getInstance().getPer100Width();
    per100Height = ScreenSizeManager.getInstance().getPer100Height();
    setupTower();
  }

  private void setupTower() {
    createPlaceHolderTower(25, 30);
    createPlaceHolderTower(25, 70);
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
    enemies.add(enemy);
    parent.addView(enemy.getView());
    enemy.setPosition(new Point(0, (int) 28 * per100Height));
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
        () -> moveEnemyWithDirection(enemy, newDirection),
        (int) (Constants.DEFAULT_DELAY_MS * (1 - enemy.getMovingSpeed() * 1f / 100)));
  }

  private EnemyDirection changeEnemyDirection(Enemy enemy, EnemyDirection direction) {
    Point position = enemy.getPosition();
    if(position.getX()>=18.28*per100Width -1 && position.getX()<=18.29*per100Width+1)
    {
      if(position.getY()<80.55*per100Height)
      {
        return EnemyDirection.DOWN;
      }
    }

    if(position.getY()>=80.55*per100Height-2&&position.getY()<=80.56*per100Height+2)
    {
      if(position.getX()<33.2*per100Width)
      {
        return EnemyDirection.RIGHT;
      }
    }

    if(position.getX()>=33.2*per100Width-2&&position.getX()<=33.3*per100Width+2)
    {
      if(position.getY()>6.94*per100Height)
      {
        return EnemyDirection.UP;
      }
    }

    if(position.getY()>=6.94*per100Height-2&&position.getY()<=6.95*per100Height+2)
    {
      if(position.getX()<84.76*per100Width)
      {
       return EnemyDirection.RIGHT;
      }
    }

    if(position.getX()>=84.76*per100Width-2&&position.getX()<=84.76*per100Width+2)
    {
      if(position.getY()<38.19*per100Height)
      {
        return EnemyDirection.DOWN;
      }
    }

    if(position.getY()>=38.19*per100Height-2&&position.getY()<=38.19*per100Height+2)
    {
        return EnemyDirection.RIGHT;
    }
    return direction;
  }

}

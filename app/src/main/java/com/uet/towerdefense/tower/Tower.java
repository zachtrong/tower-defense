package com.uet.towerdefense.tower;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.uet.towerdefense.BaseEntity;
import com.uet.towerdefense.tile.GameTile;
import com.uet.towerdefense.util.Point;

public abstract class Tower extends BaseEntity {
  abstract int getFireSpeed();

  abstract int getRange();

  abstract int getDamage();

  // TODO(1) check image size corresponding to tower
  Tower(ViewGroup parent) {
    super(parent, 80, 80);
  }

  @Override
  public int getHealth() {
    return 0;
  }

  @Override
  public int getArmor() {
    return 0;
  }

  @Override
  public int getMovingSpeed() {
    return 0;
  }

  @Override
  public int getReward() {
    return 0;
  }
}

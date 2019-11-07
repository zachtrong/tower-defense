package com.uet.towerdefense.tower;

import com.uet.towerdefense.tile.GameTile;

public abstract class Tower implements GameTile {
  abstract int getFireSpeed();
  abstract int getRange();
  abstract int getDamage();

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

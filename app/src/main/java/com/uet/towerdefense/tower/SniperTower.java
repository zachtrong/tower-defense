package com.uet.towerdefense.tower;

import com.uet.towerdefense.R;

import static com.uet.towerdefense.Constants.BASE_FIRE_DAMAGE;
import static com.uet.towerdefense.Constants.BASE_FIRE_RANGE;
import static com.uet.towerdefense.Constants.BASE_SPEED;

public class SniperTower extends Tower {
  @Override
  int getFireSpeed() {
    return BASE_SPEED;
  }

  @Override
  int getRange() {
    return (int) (BASE_FIRE_RANGE * 0.75);
  }

  @Override
  int getDamage() {
    return BASE_FIRE_DAMAGE;
  }

  @Override
  public int getDrawable() {
    return R.drawable.snipertower;
  }
}

package com.uet.towerdefense.tower;

import com.uet.towerdefense.Constants;
import com.uet.towerdefense.R;

public class MachineGunTower extends Tower {
  @Override
  int getFireSpeed() {
    return Constants.BASE_SPEED;
  }

  @Override
  int getRange() {
    return Constants.BASE_FIRE_RANGE;
  }

  @Override
  int getDamage() {
    return Constants.BASE_FIRE_DAMAGE;
  }

  @Override
  public int getDrawable() {
    return R.drawable.machineguntower;
  }
}

package com.uet.towerdefense.tower;

import android.view.ViewGroup;

import com.uet.towerdefense.Constants;
import com.uet.towerdefense.R;

public class MachineGunTower extends Tower {
  public MachineGunTower(ViewGroup parent) {
    super(parent);
  }

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

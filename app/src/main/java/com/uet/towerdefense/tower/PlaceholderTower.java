package com.uet.towerdefense.tower;

import android.view.ViewGroup;

import com.uet.towerdefense.R;

public class PlaceholderTower extends Tower {
  public PlaceholderTower(ViewGroup parent) {
    super(parent);
  }

  @Override
  int getFireSpeed() {
    return 0;
  }

  @Override
  int getRange() {
    return 0;
  }

  @Override
  int getDamage() {
    return 0;
  }

  @Override
  public int getDrawable() {
    return R.drawable.buytower;
  }
}

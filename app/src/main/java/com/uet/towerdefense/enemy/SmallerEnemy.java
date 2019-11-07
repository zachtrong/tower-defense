package com.uet.towerdefense.enemy;

import android.view.ViewGroup;

import com.uet.towerdefense.R;

public class SmallerEnemy extends Enemy {
  SmallerEnemy(ViewGroup parent) {
    super(parent);
  }

  @Override
  public int getDrawable() {
    return R.drawable.smallerenemy;
  }

  @Override
  public int getHealth() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.25);
  }

  @Override
  public int getArmor() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.25);
  }

  @Override
  public int getMovingSpeed() {
    return (int) (BASE_SPEED * 0.75);
  }

  @Override
  public int getReward() {
    return (int) (BASE_SPEED * 0.25);
  }
}
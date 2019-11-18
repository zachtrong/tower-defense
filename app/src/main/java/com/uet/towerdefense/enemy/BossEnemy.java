package com.uet.towerdefense.enemy;

import android.view.ViewGroup;

import com.uet.towerdefense.R;

import static com.uet.towerdefense.Constants.BASE_AMOUNT_HEALTH_ARMOR;
import static com.uet.towerdefense.Constants.BASE_REWARD;
import static com.uet.towerdefense.Constants.BASE_SPEED;

public class BossEnemy extends Enemy {
  public BossEnemy(ViewGroup parent) {
    super(parent);
  }

  @Override
  public int getDrawable() {
    return R.drawable.bossenemy;
  }

  @Override
  public int getHealth() {
    return BASE_AMOUNT_HEALTH_ARMOR;
  }

  @Override
  public int getArmor() {
    return BASE_AMOUNT_HEALTH_ARMOR;
  }

  @Override
  public int getMovingSpeed() {
    return (int) (BASE_SPEED * 0.25);
  }

  @Override
  public int getReward() {
    return BASE_REWARD;
  }
}

package com.uet.towerdefense.enemy;

import android.view.ViewGroup;

import com.uet.towerdefense.R;

import static com.uet.towerdefense.Constants.BASE_AMOUNT_HEALTH_ARMOR;
import static com.uet.towerdefense.Constants.BASE_REWARD;
import static com.uet.towerdefense.Constants.BASE_SPEED;

public class NormalEnemy extends Enemy {
  public NormalEnemy(ViewGroup parent) {
    super(parent);
  }

  @Override
  public int getDrawable() {
    return R.drawable.normal_enemy;
  }

  @Override
  public int getHealth() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.5);
  }

  @Override
  public int getArmor() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.5);
  }

  @Override
  public int getMovingSpeed() {
    return (int) (BASE_SPEED * 0.5);
  }

  @Override
  public int getReward() {
    return (int) (BASE_REWARD * 0.5);
  }
}

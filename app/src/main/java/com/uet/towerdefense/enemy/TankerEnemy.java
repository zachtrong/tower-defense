package com.uet.towerdefense.enemy;

import android.view.ViewGroup;

import com.uet.towerdefense.R;

import static com.uet.towerdefense.Constants.BASE_AMOUNT_HEALTH_ARMOR;
import static com.uet.towerdefense.Constants.BASE_REWARD;
import static com.uet.towerdefense.Constants.BASE_SPEED;

public class TankerEnemy extends Enemy {
  public TankerEnemy(ViewGroup parent) {
    super(parent);
  }

  @Override
  public int getDrawable() {
    return R.drawable.tankerenemy;
  }

  @Override
  public int getHealth() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.75);
  }

  @Override
  public int getArmor() {
    return (int) (BASE_AMOUNT_HEALTH_ARMOR * 0.75);
  }

  @Override
  public int getMovingSpeed() {
    return (int) (BASE_SPEED * 0.25);
  }

  @Override
  public int getReward() {
    return (int) (BASE_REWARD * 0.75);
  }
}

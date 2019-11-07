package com.uet.towerdefense;

import androidx.annotation.DrawableRes;

public interface GameEntity {
  @DrawableRes int getDrawable();
  int getHealth();
  int getArmor();
  int getMovingSpeed();
  int getReward();
}

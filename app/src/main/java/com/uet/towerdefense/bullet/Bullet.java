package com.uet.towerdefense.bullet;

import com.uet.towerdefense.Constants;
import com.uet.towerdefense.GameEntity;
import com.uet.towerdefense.R;

public class Bullet implements GameEntity {
  @Override
  public int getDrawable() {
    return R.drawable.round_fiber_manual_record_24;
  }

  @Override
  public int getMovingSpeed() {
    return 0;
  }

  @Override
  public int getHealth() {
    return 0;
  }

  @Override
  public int getReward() {
    return 0;
  }

  @Override
  public int getArmor() {
    return 0;
  }

}

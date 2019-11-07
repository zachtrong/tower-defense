package com.uet.towerdefense.tile;

import com.uet.towerdefense.R;

public class Spawner implements GameTile {
  @Override
  public int getDrawable() {
    return R.drawable.start_tile;
  }

  @Override
  public int getHealth() {
    return 0;
  }

  @Override
  public int getArmor() {
    return 0;
  }

  @Override
  public int getMovingSpeed() {
    return 0;
  }

  @Override
  public int getReward() {
    return 0;
  }
}

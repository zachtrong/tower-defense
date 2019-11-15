package com.uet.towerdefense.tower;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.uet.towerdefense.tile.GameTile;
import com.uet.towerdefense.util.Point;

public abstract class Tower implements GameTile {
  abstract int getFireSpeed();
  abstract int getRange();
  abstract int getDamage();

  private ImageView view;
  private Point position;

  Tower(ViewGroup parent) {
    view = new ImageView(parent.getContext());
    view.setImageResource(getDrawable());
  }

  public void setPosition(Point position) {
    this.position = position;
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(80, 80);
    params.setMargins((int) position.getX(), (int) position.getY(), 0, 0);
    view.setLayoutParams(params);
  }

  public ImageView getView() {
    return view;
  }

  public void setView(ImageView view) {
    this.view = view;
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

  public Point getPosition() {
    return position;
  }
}

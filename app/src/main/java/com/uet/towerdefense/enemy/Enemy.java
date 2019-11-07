package com.uet.towerdefense.enemy;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.uet.towerdefense.GameEntity;

public abstract class Enemy implements GameEntity {
  private static final int IMAGE_SIZE = 80;
  private static final int MOVING_STEP = 2;

  private int x, y;
  private ImageView view;

  Enemy(ViewGroup parent) {
    view = new ImageView(parent.getContext());
    view.setImageResource(getDrawable());
  }

  public void applyMove() {
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(IMAGE_SIZE, IMAGE_SIZE);
    params.setMargins(x, y, 0, 0);
    view.setLayoutParams(params);
  }

  public void moveLeft() {
    x -= MOVING_STEP;
    applyMove();
  }

  public void moveRight() {
    x += MOVING_STEP;
    applyMove();
  }

  public void moveUp() {
    y -= MOVING_STEP;
    applyMove();
  }

  public void moveDown() {
    y += MOVING_STEP;
    applyMove();
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public ImageView getView() {
    return view;
  }

  public void setView(ImageView view) {
    this.view = view;
  }
}

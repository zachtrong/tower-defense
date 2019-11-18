package com.uet.towerdefense;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.uet.towerdefense.util.Point;

public abstract class BaseEntity implements GameEntity {
  private static final int MOVING_STEP = 2;
  private Point position;
  private int width, height;

  private ImageView view;

  public BaseEntity(ViewGroup parent, int width, int height) {
    this.width = width;
    this.height = height;
    view = new ImageView(parent.getContext());
    view.setImageResource(getDrawable());
  }

  public void setPosition(Point position) {
    this.position = position;
    updatePosition();
  }

  public void updatePosition() {
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
    params.setMargins((int) position.getX(), (int) position.getY(), 0, 0);
    view.setLayoutParams(params);
  }

  public ImageView getView() {
    return view;
  }

  public void setView(ImageView view) {
    this.view = view;
  }

  public Point getPosition() {
    return position;
  }

  public void moveLeft() {
    position.setX(position.getX() - MOVING_STEP);
    updatePosition();
  }

  public void moveRight() {
    position.setX(position.getX() + MOVING_STEP);
    updatePosition();
  }

  public void moveUp() {
    position.setY(position.getY() - MOVING_STEP);
    updatePosition();
  }

  public void moveDown() {
    position.setY(position.getY() + MOVING_STEP);
    updatePosition();
  }
}

package com.uet.towerdefense;

import androidx.annotation.NonNull;

public class ScreenSizeManager {
  private static final ScreenSizeManager instance = new ScreenSizeManager();
  private double width, height;

  @NonNull
  public static ScreenSizeManager getInstance() {
    return instance;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getPer100Width() {
    return width * 1 / 100;
  }

  public double getPer100Height() {
    return height * 1 / 100;
  }
}

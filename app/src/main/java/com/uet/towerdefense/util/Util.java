package com.uet.towerdefense.util;

import android.view.View;

public class Util {
  public static double distance(Point lhs, Point rhs) {
    return Math.sqrt(
        (lhs.getX() - rhs.getX()) * (lhs.getX() - rhs.getX())
            - (lhs.getY() - rhs.getY()) * (lhs.getY() - rhs.getY()));
  }
}

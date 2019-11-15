package com.uet.towerdefense.enemy;

import com.uet.towerdefense.util.Point;

public enum EnemyDirection {
  UP(new Point(0, -1)),
  DOWN(new Point(0, 1)),
  LEFT(new Point(-1, 0)),
  RIGHT(new Point(1, 0));

  private Point point;

  EnemyDirection(Point point) {
    this.point = point;
  }

  public Point getPoint() {
    return point;
  }
}

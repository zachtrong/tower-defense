package com.uet.towerdefense.enemy;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.uet.towerdefense.BaseEntity;
import com.uet.towerdefense.GameEntity;

public abstract class Enemy extends BaseEntity {
  private static final int IMAGE_SIZE = 80;

  public Enemy(ViewGroup parent) {
    super(parent, IMAGE_SIZE, IMAGE_SIZE);
  }
}

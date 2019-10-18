// Generated code from Butter Knife. Do not modify!
package com.uet.towerdefense;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.startButton = Utils.findRequiredViewAsType(source, R.id.btn_start, "field 'startButton'", Button.class);
    target.highScoreButton = Utils.findRequiredViewAsType(source, R.id.btn_high_score, "field 'highScoreButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.startButton = null;
    target.highScoreButton = null;
  }
}

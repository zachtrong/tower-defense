package com.uet.towerdefense;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Random;

import butterknife.BindView;

import static com.uet.towerdefense.BuyTowerActivity.RESULT_CANCELBUY;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_MACHINEGUN;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_SNIPER;
import static com.uet.towerdefense.BuyTowerActivity.RESULT_TOWERNULL;
import static java.lang.Integer.parseInt;

public class GamePlayActivity extends BaseActivity {

  public static int returnData;
  public static int t = 1;

  public static int numberOfSinhQuai = 1;
  public static ImageButton idBuyTower;

  private static int numberOfMonster1 = 1;
  public static Random generator = new Random();
  private static int numberMonsterToDestination = 3;
  private static int smallerStep = 5;
  private static int tankerStep = 3;
  private static int bossStep = 5;

  @BindView(R.id.monster)
  ImageView monster;

  @BindView(R.id.btn_tower)
  ImageButton tower;

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_gameplay;
  }

  @Override
  protected void setupListener() {

    startMonster();
    tower.setBackground(null);
    tower.setOnClickListener(
        view -> {
          buyTower(tower);
        });
  }

  @Override
  protected void populateData() {}

  public void startMonster() {
    CountDownTimer countDownTimer =
        new CountDownTimer(3000000, 30000) {
          @Override
          public void onTick(long millisUntilFinished) {

            sinhQuai1();
          }

          @Override
          public void onFinish() {}
        }.start();
  }

  private void buyTower(ImageButton imageButton) {
    idBuyTower = imageButton;
    Intent intent = new Intent();
    intent.setClass(this, BuyTowerActivity.class);
    startActivityForResult(intent, returnData);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == returnData) {
      if (resultCode == RESULT_MACHINEGUN) {

        int setmachinegun = Integer.parseInt(data.getStringExtra("machinegun"));
        idBuyTower.setImageResource(setmachinegun);
        idBuyTower.setBackground(null);
      }
      if (resultCode == RESULT_SNIPER) {
        int setsniper = Integer.parseInt(data.getStringExtra("sniper"));
        idBuyTower.setImageResource(setsniper);
        idBuyTower.setBackground(null);
      }
      if (resultCode == RESULT_TOWERNULL) {
        idBuyTower.setImageResource(R.drawable.buytower);
        // tăng coin
      }
      if (resultCode == RESULT_CANCELBUY) {
        // cancel=> không làm gì
      }
    }
  }

  private void sinhQuai1() {

    int step;
    monster.setImageResource(R.drawable.smallerenemy);
    step = smallerStep;
    numberOfMonster1++;

    CountDownTimer countDownTimer =
        new CountDownTimer(3000000, 20) {

          @Override
          public void onTick(long millisUntilFinished) {

            if (monster1.getLeft() <= 294) {
              monster1.setLeft(monster1.getLeft() + step);
              monster1.setRight(monster1.getRight() + step);
            }
            if (monster1.getLeft() >= 294 && monster1.getTop() <= 824 && monster1.getLeft() < 570) {
              monster1.setTop(monster1.getTop() + step);
              monster1.setBottom(monster1.getBottom() + step);
            }
            if (monster1.getLeft() <= 570 && monster1.getTop() >= 825) {
              monster1.setLeft(monster1.getLeft() + step);
              monster1.setRight(monster1.getRight() + step);
            }
            if (monster1.getLeft() >= 570
                && monster1.getTop() >= 40
                && monster1.getLeft() <= 1500) {

              monster1.setLeft(monster1.getLeft() + 0);
              monster1.setTop(monster1.getTop() - step);
              monster1.setRight(monster1.getRight() + 0);
              monster1.setBottom(monster1.getBottom() - 0);
            }
            if (monster1.getLeft() <= 1510
                && monster1.getTop() <= 40
                && monster1.getLeft() >= 570) {
              monster1.setLeft(monster1.getLeft() + step);
              monster1.setRight(monster1.getRight() + step);

            }
            if (monster1.getLeft() >= 1510 && monster1.getTop() <= 370 && monster1.getTop() >= 30) {
              monster1.setTop(monster1.getTop() + step);
              monster1.setBottom(monster1.getBottom() + step);
            }
            if (monster1.getLeft() >= 1510
                && monster1.getTop() >= 370
                && monster1.getLeft() <= 1820) {
              monster1.setLeft(monster1.getLeft() + step);
              monster1.setRight(monster1.getRight() + step);
            }
            if (monster1.getLeft() >= 1820) {
              numberMonsterToDestination--;
            }
          }

          @Override
          public void onFinish() {}
        };
    countDownTimer.start();
  }
}

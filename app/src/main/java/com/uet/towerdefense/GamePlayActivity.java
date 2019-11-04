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
    public static int t=1;

    public static int numberOfSinhQuai = 1;
    public static ImageButton idBuyTower;

    private static int numberOfMonster1 = 1;
    private static int numberOfMonster2 = 1;
    private static int numberOfMonster3 = 1;
    private static int numberOfMonster4 = 1;
    public static Random generator = new Random();
    private static int numberMonsterToDestination = 3;
    private static int smallerStep = 5;
    private static int tankerStep = 3;
    private static int bossStep = 5;
    @BindView(R.id.monster1)
    ImageView monster1;
    @BindView(R.id.monster2)
    ImageView monster2;
    @BindView(R.id.monster3)
    ImageView monster3;
    @BindView(R.id.monster4)
    ImageView monster4;




    @BindView(R.id.btn_tower1)
    ImageButton tower1;
    @BindView(R.id.btn_tower2)
    ImageButton tower2;
    @BindView(R.id.btn_tower3)
    ImageButton tower3;
    @BindView(R.id.btn_tower4)
    ImageButton tower4;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_gameplay;
    }

    @Override
    protected void setupListener() {

        startMonster();
//        sinhQuai1();
        tower1.setBackground(null);
        tower2.setBackground(null);
        tower3.setBackground(null);
        tower4.setBackground(null);
        tower1.setOnClickListener(
                view -> {

                    buyTower(tower1);
                });
        tower2.setOnClickListener(
                view -> {
                    buyTower(tower2);
                });
        tower3.setOnClickListener(
                view -> {
                    buyTower(tower3);
                });
        tower4.setOnClickListener(
                view -> {
                    buyTower(tower4);
                });


    }


    @Override
    protected void populateData() {


    }


    public void startMonster()
    {
        CountDownTimer countDownTimer= new CountDownTimer(3000000,30000) {
            @Override
            public void onTick(long millisUntilFinished) {

                    sinhQuai1();
                    sinhQuai2();
                    sinhQuai3();
                    sinhQuai4();



            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
        private void buyTower(ImageButton imageButton) {
            idBuyTower =imageButton;
            Intent intent= new Intent();
            intent.setClass(this,BuyTowerActivity.class);
            startActivityForResult(intent,returnData);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==returnData)
            {
                if(resultCode==RESULT_MACHINEGUN)
                {

                    int setmachinegun=Integer.parseInt(data.getStringExtra("machinegun"));
                    idBuyTower.setImageResource(setmachinegun);
                    idBuyTower.setBackground(null);

                }
                if(resultCode==RESULT_SNIPER)
                {
                    int setsniper=Integer.parseInt(data.getStringExtra("sniper"));
                    idBuyTower.setImageResource(setsniper);
                    idBuyTower.setBackground(null);
                }
                if(resultCode==RESULT_TOWERNULL)
                {
                    idBuyTower.setImageResource(R.drawable.buytower);
                    // tăng coin
                }
                if(resultCode==RESULT_CANCELBUY)
                {
                    // cancel=> không làm gì
                }
            }
        }
    private void sinhQuai1() {

       /* int step;
        int randomMonster = generator.nextInt(2) + 1;
        if (randomMonster == 1 && numberOfMonster % 10 != 0) {
            monster1.setImageResource(R.drawable.smallerenemy);
            numberOfMonster++;
            step = smallerStep;
        } else if (randomMonster == 2 && numberOfMonster % 10 != 0) {
            monster1.setImageResource(R.drawable.tankerenemy);
            numberOfMonster++;
            step = tankerStep;
        } else if (numberOfMonster % 10 == 0 && numberOfMonster != 0) {
            monster1.setImageResource(R.drawable.bossenemy);
            numberOfMonster++;
            step = bossStep;
        } else {

            numberOfMonster++;
            step = smallerStep;
        }*/
       int step;
       if(numberOfMonster1==1)
       {
           monster1.setImageResource(R.drawable.smallerenemy);
           step=smallerStep;
           numberOfMonster1++;
       }
       else if(numberOfMonster1%2==0)
       {
           monster1.setImageResource(R.drawable.tankerenemy);
           step=tankerStep-smallerStep;
           numberOfMonster1++;
       }
       else
       {
           monster1.setImageResource(R.drawable.smallerenemy);
           step=smallerStep-tankerStep;
           numberOfMonster1++;
       }


        CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {

            @Override
            public void onTick(long millisUntilFinished) {

                if (monster1.getLeft() <= 294) {
                    monster1.setLeft(monster1.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster1.setRight(monster1.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster1.getLeft() >= 294 && monster1.getTop() <= 824 && monster1.getLeft() < 570) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster1.setTop(monster1.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster1.setBottom(monster1.getBottom() + step);
                }
                if (monster1.getLeft() <= 570 && monster1.getTop() >= 825) {
                    monster1.setLeft(monster1.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster1.setRight(monster1.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster1.getLeft() >= 570 && monster1.getTop() >= 40 && monster1.getLeft() <= 1500) {

                    monster1.setLeft(monster1.getLeft() + 0);
                    monster1.setTop(monster1.getTop() - step);
                    monster1.setRight(monster1.getRight() + 0);
                    monster1.setBottom(monster1.getBottom() - 0);

                }
                if (monster1.getLeft() <= 1510 && monster1.getTop() <= 40 && monster1.getLeft() >= 570) {
                    monster1.setLeft(monster1.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster1.setRight(monster1.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);

                }
                if (monster1.getLeft() >= 1510 && monster1.getTop() <= 370 && monster1.getTop() >= 30) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster1.setTop(monster1.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster1.setBottom(monster1.getBottom() + step);
                }
                if (monster1.getLeft() >= 1510 && monster1.getTop() >= 370 && monster1.getLeft() <= 1820) {
                    monster1.setLeft(monster1.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster1.setRight(monster1.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster1.getLeft() >= 1820) {

                    // bossplay.setImageResource(R.drawable.tankerenemy);
                    numberMonsterToDestination--;

                }

            }

            @Override
            public void onFinish() {


            }

        };
        countDownTimer.start();


    }

    private void sinhQuai2() {

       /* int step;
        int randomMonster = generator.nextInt(2) + 1;
        if (randomMonster == 1 && numberOfMonster % 10 != 0) {
            step = smallerStep;
            monster2.setImageResource(R.drawable.smallerenemy);
            numberOfMonster++;
        } else if (randomMonster == 2 && numberOfMonster % 10 != 0) {
            step = tankerStep;
            monster2.setImageResource(R.drawable.tankerenemy);
            numberOfMonster++;
        } else if (numberOfMonster % 10 == 0 && numberOfMonster != 0) {
            step = bossStep;
            monster2.setImageResource(R.drawable.bossenemy);
            numberOfMonster++;
        } else {
            step = smallerStep;
            numberOfMonster++;
        }*/
        int step;
        if(numberOfMonster2==1)
        {
            monster2.setImageResource(R.drawable.tankerenemy);
            step=tankerStep;
            numberOfMonster2++;
        }
        else if(numberOfMonster2%2==0)
        {
            monster2.setImageResource(R.drawable.smallerenemy);
            step=smallerStep-tankerStep;
            numberOfMonster2++;
        }
        else
        {
            monster2.setImageResource(R.drawable.tankerenemy);
            step=tankerStep-smallerStep;
            numberOfMonster2++;
        }

        CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (monster2.getLeft() <= 294) {
                    monster2.setLeft(monster2.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster2.setRight(monster2.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster2.getLeft() >= 294 && monster2.getTop() <= 824 && monster2.getLeft() < 570) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster2.setTop(monster2.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster2.setBottom(monster2.getBottom() + step);
                }
                if (monster2.getLeft() <= 570 && monster2.getTop() >= 825) {
                    monster2.setLeft(monster2.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster2.setRight(monster2.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster2.getLeft() >= 570 && monster2.getTop() >= 40 && monster2.getLeft() <= 1500) {

                    monster2.setLeft(monster2.getLeft() + 0);
                    monster2.setTop(monster2.getTop() - step);
                    monster2.setRight(monster2.getRight() + 0);
                    monster2.setBottom(monster2.getBottom() - 0);

                }
                if (monster2.getLeft() <= 1510 && monster2.getTop() <= 40 && monster2.getLeft() >= 570) {
                    monster2.setLeft(monster2.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster2.setRight(monster2.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);

                }
                if (monster2.getLeft() >= 1510 && monster2.getTop() <= 370 && monster2.getTop() >= 30) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster2.setTop(monster2.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster2.setBottom(monster2.getBottom() + step);
                }
                if (monster2.getLeft() >= 1510 && monster2.getTop() >= 370 && monster2.getLeft() <= 1820) {
                    monster2.setLeft(monster2.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster2.setRight(monster2.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster2.getLeft() >= 1820) {

                    numberMonsterToDestination--;

                    //  bossplay.setImageResource(R.drawable.tankerenemy);
                }

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void sinhQuai3() {

       /* int step;
        int randomMonster = generator.nextInt(2) + 1;
        if (randomMonster == 1 && numberOfMonster % 10 != 0) {
            step = smallerStep;
            monster3.setImageResource(R.drawable.smallerenemy);
            numberOfMonster++;
        } else if (randomMonster == 2 && numberOfMonster % 10 != 0) {
            step = tankerStep;
            monster3.setImageResource(R.drawable.tankerenemy);
            numberOfMonster++;
        } else if (numberOfMonster % 10 == 0 && numberOfMonster != 0) {
            step = bossStep;
            monster3.setImageResource(R.drawable.bossenemy);
            numberOfMonster++;
        } else {
            step = smallerStep;
            numberOfMonster++;
        }*/
        int step;
        if(numberOfMonster3==1)
        {
            monster3.setImageResource(R.drawable.smallerenemy);
            step=smallerStep;
            numberOfMonster3++;
        }
        else if(numberOfMonster3%2==0)
        {
            monster3.setImageResource(R.drawable.tankerenemy);
            step=tankerStep-smallerStep;
            numberOfMonster3++;
        }
        else
        {
            monster3.setImageResource(R.drawable.smallerenemy);
            step=smallerStep-tankerStep;
            numberOfMonster3++;
        }
        CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (monster3.getLeft() <= 294) {
                    monster3.setLeft(monster3.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster3.setRight(monster3.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster3.getLeft() >= 294 && monster3.getTop() <= 824 && monster3.getLeft() < 570) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster3.setTop(monster3.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster3.setBottom(monster3.getBottom() + step);
                }
                if (monster3.getLeft() <= 570 && monster3.getTop() >= 825) {
                    monster3.setLeft(monster3.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster3.setRight(monster3.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster3.getLeft() >= 570 && monster3.getTop() >= 40 && monster3.getLeft() <= 1500) {

                    monster3.setLeft(monster3.getLeft() + 0);
                    monster3.setTop(monster3.getTop() - step);
                    monster3.setRight(monster3.getRight() + 0);
                    monster3.setBottom(monster3.getBottom() - 0);

                }
                if (monster3.getLeft() <= 1510 && monster3.getTop() <= 40 && monster3.getLeft() >= 570) {
                    monster3.setLeft(monster3.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster3.setRight(monster3.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);

                }
                if (monster3.getLeft() >= 1510 && monster3.getTop() <= 370 && monster3.getTop() >= 30) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster3.setTop(monster3.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster3.setBottom(monster3.getBottom() + step);
                }
                if (monster3.getLeft() >= 1510 && monster3.getTop() >= 370 && monster3.getLeft() <= 1820) {
                    monster3.setLeft(monster3.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster3.setRight(monster3.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster3.getLeft() >= 1800) {

                    //bossplay.setImageResource(R.drawable.tankerenemy);
                    numberMonsterToDestination--;
                }

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void sinhQuai4() {

       /* int step;
        int randomMonster = generator.nextInt(2) + 1;
        if (randomMonster == 1 && numberOfMonster % 10 != 0) {
            monster4.setImageResource(R.drawable.smallerenemy);
            numberOfMonster++;
            step = smallerStep;
        } else if (randomMonster == 2 && numberOfMonster % 10 != 0) {
            monster4.setImageResource(R.drawable.tankerenemy);
            numberOfMonster++;
            step = tankerStep;
        } else if (numberOfMonster % 10 == 0 && numberOfMonster != 0) {
            monster4.setImageResource(R.drawable.bossenemy);
            numberOfMonster++;
            step = bossStep;
        } else {
            numberOfMonster++;
            step = smallerStep;
        }
*/      int step;
        if(numberOfMonster4==1)
        {
            monster4.setImageResource(R.drawable.tankerenemy);
            step=tankerStep;
            numberOfMonster4++;
        }
        else if(numberOfMonster4%2==0)
        {
            monster4.setImageResource(R.drawable.smallerenemy);
            step=smallerStep-tankerStep;
            numberOfMonster4++;
        }
        else
        {
            monster4.setImageResource(R.drawable.tankerenemy);
            step=tankerStep-smallerStep;
            numberOfMonster4++;
        }
        CountDownTimer countDownTimer = new CountDownTimer(3000000, 20) {

            @Override
            public void onTick(long millisUntilFinished) {

                if (monster4.getLeft() <= 294) {
                    monster4.setLeft(monster4.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster4.setRight(monster4.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster4.getLeft() >= 294 && monster4.getTop() <= 824 && monster4.getLeft() < 570) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster4.setTop(monster4.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster4.setBottom(monster4.getBottom() + step);
                }
                if (monster4.getLeft() <= 570 && monster4.getTop() >= 825) {
                    monster4.setLeft(monster4.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster4.setRight(monster4.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster4.getLeft() >= 570 && monster4.getTop() >= 40 && monster4.getLeft() <= 1500) {

                    monster4.setLeft(monster4.getLeft() + 0);
                    monster4.setTop(monster4.getTop() - step);
                    monster4.setRight(monster4.getRight() + 0);
                    monster4.setBottom(monster4.getBottom() - 0);

                }
                if (monster4.getLeft() <= 1510 && monster4.getTop() <= 40 && monster4.getLeft() >= 570) {
                    monster4.setLeft(monster4.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster4.setRight(monster4.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);

                }
                if (monster4.getLeft() >= 1510 && monster4.getTop() <= 370 && monster4.getTop() >= 30) {
                    //bossplay.setLeft(bossplay.getLeft()+1);
                    monster4.setTop(monster4.getTop() + step);
                    //bossplay.setRight(bossplay.getRight()+1);
                    monster4.setBottom(monster4.getBottom() + step);
                }
                if (monster4.getLeft() >= 1510 && monster4.getTop() >= 370 && monster4.getLeft() <= 1820) {
                    monster4.setLeft(monster4.getLeft() + step);
                    //bossplay.setTop(bossplay.getTop()+0);
                    monster4.setRight(monster4.getRight() + step);
                    //bossplay.setBottom(bossplay.getBottom()+0);
                }
                if (monster4.getLeft() >= 1820) {

                    // bossplay.setImageResource(R.drawable.tankerenemy);
                    numberMonsterToDestination--;

                }

            }

            @Override
            public void onFinish() {


            }

        };
        countDownTimer.start();


    }

}

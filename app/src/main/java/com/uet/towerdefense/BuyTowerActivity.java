package com.uet.towerdefense;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.BindView;

public class BuyTowerActivity extends BaseActivity {
    public static final String KEY_SET_TOWER_MACHINEGUN ="SETTOWER" ;
    public static final int RESULT_SNIPER = 1912 ;
    public static final int RESULT_MACHINEGUN = 0230 ;
    public static final int RESULT_NORMALTOWE = 2011 ;
    public static final int RESULT_TOWERNULL = 1234;
    public static final int RESULT_CANCELBUY = 4321 ;

    @BindView(R.id.btn_buy_machinegun)
    Button buyMachinegun;

    @BindView(R.id.btn_sell_machinegun)
    Button sellMachinegun;

    @BindView(R.id.btn_buy_sniper)
    Button buySniper;

    @BindView(R.id.btn_sell_sniper)
    Button sellSniper;

    @BindView(R.id.btn_buy_normal_tower)
    Button buyNormalTower;

    @BindView(R.id.btn_sell_normal_tower)
    Button sellNormalTower;



    @Override
    protected int getLayoutRes()
    {
        return R.layout.activity_buy_tower;
    }

    @Override
    protected void setupListener() {
        buyMachinegun.setOnClickListener( view ->{

            setTowerMachinegun();
        });
        sellMachinegun.setOnClickListener( view ->{

            setTowerNull();

        });
        buySniper.setOnClickListener( view ->{

            setTowerSniper();

        });
        sellSniper.setOnClickListener( view ->{

            setTowerNull();

        });
        buyNormalTower.setOnClickListener( view ->{

            setTowerNormal();
        });
        sellNormalTower.setOnClickListener( view ->{

            setTowerNull();

        });

    }

    private void setTowerNormal() {
        Intent intent=new Intent();
        setResult(RESULT_NORMALTOWE,intent);
        finish();
    }

    private void setTowerSniper() {
        Intent intent=new Intent();
        setResult(RESULT_SNIPER,intent);
        finish();

    }

    public void setTowerMachinegun() {
        Intent intent=new Intent();
        setResult(RESULT_MACHINEGUN,intent);
        finish();
    }

    private void setTowerNull() {
        Intent intent=new Intent();
        setResult(RESULT_TOWERNULL,intent);
        finish();
    }



    @Override
    protected void populateData() {

    }
}

package com.uet.towerdefense;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.BindView;

public class BuyTowerActivity extends BaseActivity {
    public static final String KEY_SET_TOWER_MACHINEGUN ="SETTOWER" ;
    public static final int RESULT_SNIPER =1912 ;
    public static final int RESULT_MACHINEGUN =0230 ;
    public static final int RESULT_TOWERNULL = 1234;
    public static final int RESULT_CANCELBUY =4321 ;
    @BindView(R.id.btn_buy_machinegun)
    Button buyMachinegun;

    @BindView(R.id.btn_sell_machinegun)
    Button sellMachinegun;

    @BindView(R.id.btn_buy_sniper)
    Button buySniper;

    @BindView(R.id.btn_sell_sniper)
    Button sellSniper;

    @BindView(R.id.btn_cancel)
    Button cancel;


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
        cancel.setOnClickListener( view ->{

            setCancelBuy();

        });

    }

    private void setCancelBuy() {
        String setcancelbuy="";
        Intent intent=new Intent();
        intent.putExtra("setcancelbuy",setcancelbuy);
        setResult(RESULT_CANCELBUY,intent);
        finish();
    }

    private void setTowerSniper() {
        String machinegun=String.valueOf(R.drawable.snipertower);
        Intent intent=new Intent();
        intent.putExtra("sniper",machinegun);
        setResult(RESULT_SNIPER,intent);
        finish();

    }

    public void setTowerMachinegun() {
        String machinegun=String.valueOf(R.drawable.machineguntower);
        Intent intent=new Intent();
        intent.putExtra("machinegun",machinegun);
        setResult(RESULT_MACHINEGUN,intent);
        finish();
    }

    private void setTowerNull() {
        String settowernull="";
        Intent intent=new Intent();
        intent.putExtra("settowernull",settowernull);
        setResult(RESULT_TOWERNULL,intent);
        finish();
    }



    @Override
    protected void populateData() {

    }
}

package com.dybinski.midioverbluetooth;

import android.app.ActivityOptions;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Frontend extends AppCompatActivity {

    ImageView btOff,btOn;
    TextView titleUp, titleDown;

    ViewGroup wholeLayout;


    protected BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> pairedDevices;
    public static boolean wasConnected = false;

    private bluetoothHandler btHandler;

    private boolean pairDevice(){
        if(!bluetoothAdapter.isEnabled()){
            //Toast.makeText(getApplicationContext(),"Bluetooth jest wyłączony.",Toast.LENGTH_SHORT).show();
            Intent wlaczBT =  new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(wlaczBT,1);
        }

        pairedDevices = bluetoothAdapter.getBondedDevices();
        ArrayList list = new ArrayList();
        boolean paired = false;
        if (pairedDevices.size()>0){
            for(BluetoothDevice bt : pairedDevices){
                if(bt.getAddress().equals("20:13:05:17:34:58")){
                    paired = true;
                   // Toast.makeText(getApplicationContext(),"Moduł MIDI jest sparowany.",Toast.LENGTH_SHORT).show();
                    //statusField.setText(bt.getAddress().toString());
                    btEnable();

                }
            }
            if(!paired){
               // Toast.makeText(getApplicationContext(),"Moduł MIDI nie jest sparowany.",Toast.LENGTH_SHORT).show();
            }
        }
        return paired;
    }




    @Override
    protected void onResume(){
        super.onResume();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        Transition trans = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(trans);

        Transition reenterTrans = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setReenterTransition(reenterTrans);

        setContentView(R.layout.activity_frontend);
        FadeIn();
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long miliseconds){

            }

            @Override
            public void onFinish(){
                rozwin();
            }
        }.start();

        wholeLayout=(ViewGroup)findViewById(R.id.frontend);
        wholeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(!rozwinieto)rozwin();
            }
        });




        titleUp = (TextView)findViewById(R.id.title1);
        titleDown = (TextView)findViewById(R.id.title2);

        btOff = (ImageView) findViewById(R.id.btDis);
        btOn = (ImageView) findViewById(R.id.btEna);

        btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                btHandler = new bluetoothHandler();
                pairDevice();

                    btEnable();




            }
        });
        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void FadeIn() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout lay = (RelativeLayout) findViewById(R.id.content);
        lay.clearAnimation();
        lay.startAnimation(anim);

    }
    public void FadeOut() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        anim.reset();
        RelativeLayout lay = (RelativeLayout) findViewById(R.id.content);
        lay.clearAnimation();
        lay.startAnimation(anim);

    }
/*
    }
    public void BtOn(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        anim.reset();
        ImageView disabled = (ImageView) findViewById(R.id.btDis);
        disabled.clearAnimation();
        disabled.startAnimation(anim);


        anim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anim.reset();
        ImageView enabled = (ImageView) findViewById(R.id.btEna);
        enabled.clearAnimation();
        enabled.startAnimation(anim);
    }*/
    public void rozwin(){
        TransitionManager.beginDelayedTransition(wholeLayout);
        ViewGroup.LayoutParams sizeRules = btOff.getLayoutParams();
        sizeRules.width=200;
        sizeRules.height=200;
        btOff.setLayoutParams(sizeRules);
        btOff.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams marginRules = (RelativeLayout.LayoutParams) titleUp.getLayoutParams();
        marginRules.setMargins(0,0,0,80);
        titleUp.setLayoutParams(marginRules);
        marginRules = (RelativeLayout.LayoutParams) titleDown.getLayoutParams();
        marginRules.setMargins(0,80,0,0);
        titleDown.setLayoutParams(marginRules);

    }
    public void btEnable(){
        TransitionManager.beginDelayedTransition(wholeLayout);

        btOff.setVisibility(View.INVISIBLE);
        btOn.setVisibility(View.VISIBLE);

        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long miliseconds){}

            @Override
            public void onFinish(){
                TransitionManager.beginDelayedTransition(wholeLayout);
                wholeLayout.setVisibility(View.INVISIBLE);
                new CountDownTimer(400,100){

                    @Override
                    public void onTick(long miliseconds){}

                    @Override
                    public void onFinish(){
                        next();
                    }
                }.start();



            }
        }.start();
    }
    public void next() {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Frontend.this);
        Intent i = new Intent(Frontend.this, Controllers.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NO_ANIMATION);

        startActivity(i,options.toBundle());
        //overridePendingTransition(R.anim.fadein,R.anim.fadeout);

    }


}


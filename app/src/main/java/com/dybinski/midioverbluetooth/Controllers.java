package com.dybinski.midioverbluetooth;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

import static com.dybinski.midioverbluetooth.R.color.colorAccent2;
import static com.dybinski.midioverbluetooth.R.color.colorBackgroungLight;
import static com.dybinski.midioverbluetooth.R.color.colorPrimary;
import static com.dybinski.midioverbluetooth.R.color.colorPrimaryDark;

public class Controllers extends AppCompatActivity {



    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
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

        Transition enterTrans = new Fade();
        getWindow().setEnterTransition(enterTrans);
        Transition returnTrans = TransitionInflater.from(this).inflateTransition(R.transition.slow_auto_transition);
        getWindow().setReturnTransition(returnTrans);
        setContentView(R.layout.activity_controllers);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() {
        }
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        /*
        @Override
        public void onResume()
        {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1)
            {

            }
        }*/
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;

            final bluetoothHandler btHandler=new bluetoothHandler();


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                rootView = inflater.inflate(R.layout.keyboard,container,false);

                /////////////////////////////////////////////////////////////////////////   KLAWISZE
                final Button cKey = (Button)rootView.findViewById(R.id.cKey);
                cKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.c , 127);
                            cKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.c , 0);
                            cKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button dKey = (Button)rootView.findViewById(R.id.dKey);
                dKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn, MIDI.d , 127);
                            dKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.d , 0);
                            dKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button eKey = (Button)rootView.findViewById(R.id.eKey);
                eKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.e , 127);
                            eKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.e , 0);
                            eKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button fKey = (Button)rootView.findViewById(R.id.fKey);
                fKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.f , 127);
                            fKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.f , 0);
                            fKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button gKey = (Button)rootView.findViewById(R.id.gKey);
                gKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.g , 127);
                            gKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.g , 0);
                            gKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button aKey = (Button)rootView.findViewById(R.id.aKey);
                aKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.a , 127);
                            aKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.a , 0);
                            aKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button hKey = (Button)rootView.findViewById(R.id.hKey);
                hKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.h , 127);
                            hKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.h , 0);
                            hKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button ccKey = (Button)rootView.findViewById(R.id.ccKey);
                ccKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.cc , 127);
                            ccKey.setBackgroundColor(getResources().getColor(R.color.keyWhitePressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.cc , 0);
                            ccKey.setBackgroundColor(getResources().getColor(R.color.keyWhite));
                        }
                        return true;
                    }});
                final Button cisKey = (Button)rootView.findViewById(R.id.cisKey);
                cisKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.cis , 127);
                            cisKey.setBackgroundColor(getResources().getColor(R.color.keyBlackPressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.cis , 0);
                            cisKey.setBackgroundColor(getResources().getColor(R.color.keyBlack));
                        }
                        return true;
                    }});
                final Button disKey = (Button)rootView.findViewById(R.id.disKey);
                disKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.dis , 127);
                            disKey.setBackgroundColor(getResources().getColor(R.color.keyBlackPressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.dis , 0);
                            disKey.setBackgroundColor(getResources().getColor(R.color.keyBlack));
                        }
                        return true;
                    }});
                final Button fisKey = (Button)rootView.findViewById(R.id.fisKey);
                fisKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.fis , 127);
                            fisKey.setBackgroundColor(getResources().getColor(R.color.keyBlackPressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.fis , 0);
                            fisKey.setBackgroundColor(getResources().getColor(R.color.keyBlack));
                        }
                        return true;
                    }});
                final Button gisKey = (Button)rootView.findViewById(R.id.gisKey);
                gisKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.gis , 127);
                            gisKey.setBackgroundColor(getResources().getColor(R.color.keyBlackPressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.gis , 0);
                            gisKey.setBackgroundColor(getResources().getColor(R.color.keyBlack));
                        }
                        return true;
                    }});
                final Button aisKey = (Button)rootView.findViewById(R.id.aisKey);
                aisKey.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction()==MotionEvent.ACTION_DOWN) {
                            btHandler.midiMessage(MIDI.NoteOn,  MIDI.ais , 127);
                            aisKey.setBackgroundColor(getResources().getColor(R.color.keyBlackPressed));
                        }
                        if(event.getAction()==MotionEvent.ACTION_UP) {
                            btHandler.midiMessage(MIDI.NoteOff,  MIDI.ais , 0);
                            aisKey.setBackgroundColor(getResources().getColor(R.color.keyBlack));
                        }
                        return true;
                    }});
                final Button nextKey = (Button)rootView.findViewById(R.id.nextKey);
                nextKey.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                //////////////////////////////////////////////////////////////////////////////////////
            }












            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                rootView = inflater.inflate(R.layout.knobs, container, false);

                ////////////////////////////////////////// PARAM 1
                final TextView text1 = (TextView)rootView.findViewById(R.id.titleText1);
                text1.setText(getParamName(param1));
                final TextView status1 = (TextView)rootView.findViewById(R.id.statusText1);
                final SeekBar bar1 = (SeekBar)rootView.findViewById(R.id.progresBar1);
                bar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=bar1.getProgress();

                        btHandler.midiMessage(MIDI.ControlChange,getParamMidi(param1),wartosc);
                        status1.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                text1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(param1==11)param1=0;
                        param1++;
                        text1.setText(getParamName(param1));
                        bar1.setProgress(63);
                    }
                });
                ////////////////////////////////////////// PARAM 2
                final TextView text2 = (TextView)rootView.findViewById(R.id.titleText2);
                text2.setText(getParamName(param2));
                final TextView status2 = (TextView)rootView.findViewById(R.id.statusText2);
                final SeekBar bar2 = (SeekBar)rootView.findViewById(R.id.progresBar2);
                bar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=bar2.getProgress();

                        btHandler.midiMessage(MIDI.ControlChange,getParamMidi(param2),wartosc);
                        status2.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                text2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(param2==11)param2=0;
                        param2++;
                        text2.setText(getParamName(param2));
                        bar2.setProgress(63);
                    }
                });
                ////////////////////////////////////////// PARAM 3
                final TextView text3 = (TextView)rootView.findViewById(R.id.titleText3);
                text3.setText(getParamName(param3));
                final TextView status3 = (TextView)rootView.findViewById(R.id.statusText3);
                final SeekBar bar3 = (SeekBar)rootView.findViewById(R.id.progresBar3);
                bar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=bar3.getProgress();

                        btHandler.midiMessage(MIDI.ControlChange,getParamMidi(param3),wartosc);
                        status3.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                text3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(param3==11)param3=0;
                        param3++;
                        text3.setText(getParamName(param3));
                        bar3.setProgress(63);
                    }
                });
                ////////////////////////////////////////// PARAM 4
                final TextView text4 = (TextView)rootView.findViewById(R.id.titleText4);
                text4.setText(getParamName(param4));
                final TextView status4 = (TextView)rootView.findViewById(R.id.statusText4);
                final SeekBar bar4 = (SeekBar)rootView.findViewById(R.id.progresBar4);
                bar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=bar4.getProgress();

                        btHandler.midiMessage(MIDI.ControlChange,getParamMidi(param4),wartosc);
                        status4.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                text4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(param4==11)param4=0;
                        param4++;
                        text4.setText(getParamName(param4));
                        bar4.setProgress(63);
                    }
                });
                ////////////////////////////////////////// PARAM 5
                final TextView text5 = (TextView)rootView.findViewById(R.id.titleText5);
                text5.setText(getParamName(param5));
                final TextView status5 = (TextView)rootView.findViewById(R.id.statusText5);
                final SeekBar bar5 = (SeekBar)rootView.findViewById(R.id.progresBar5);
                bar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=bar5.getProgress();

                        btHandler.midiMessage(MIDI.ControlChange,getParamMidi(param5),wartosc);
                        status5.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {


                    }
                });
                text5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(param5==11)param5=0;
                        param5++;
                        text5.setText(getParamName(param5));
                        bar5.setProgress(63);
                    }
                });


            }







            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                rootView = inflater.inflate(R.layout.settings, container, false);
                ////////////////////////////////////////// SETTING 1
                final TextView settingText1 = (TextView)rootView.findViewById(R.id.settingsStatus1);
                final SeekBar settingBar1 = (SeekBar)rootView.findViewById(R.id.settingsBar1);
                settingBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=settingBar1.getProgress();
                        settingText1.setText(Integer.toString(wartosc));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        int wartosc=settingBar1.getProgress();
                        btHandler.midiProgramChange(wartosc);
                    }
                });
                ////////////////////////////////////////// SETTING 2
                final TextView settingText2 = (TextView)rootView.findViewById(R.id.settingsStatus2);
                final SeekBar settingBar2 = (SeekBar)rootView.findViewById(R.id.settingsBar2);
                settingBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=settingBar2.getProgress();
                        settingText2.setText(Integer.toString(wartosc));
                        MIDI.channel=wartosc;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                ////////////////////////////////////////// SETTING 3
                final TextView settingText3 = (TextView)rootView.findViewById(R.id.settingsStatus3);
                final SeekBar settingBar3 = (SeekBar)rootView.findViewById(R.id.settingsBar3);
                settingBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int wartosc=settingBar3.getProgress();
                        settingText3.setText(Integer.toString(wartosc-2));

                        /*
                        MIDI.c=MIDI.c+12*(settingBar3.getProgress()-2);
                        MIDI.cis=MIDI.cis+12*(settingBar3.getProgress()-2);
                        MIDI.d=MIDI.d+12*(settingBar3.getProgress()-2);
                        MIDI.dis=MIDI.dis+12*(settingBar3.getProgress()-2);
                        MIDI.e=MIDI.e+12*(settingBar3.getProgress()-2);
                        MIDI.f=MIDI.f+12*(settingBar3.getProgress()-2);
                        MIDI.fis=MIDI.fis+12*(settingBar3.getProgress()-2);
                        MIDI.g=MIDI.g+12*(settingBar3.getProgress()-2);
                        MIDI.gis=MIDI.gis+12*(settingBar3.getProgress()-2);
                        MIDI.a=MIDI.a+12*(settingBar3.getProgress()-2);
                        MIDI.ais=MIDI.ais+12*(settingBar3.getProgress()-2);
                        MIDI.h=MIDI.h+12*(settingBar3.getProgress()-2);
                        MIDI.cc=MIDI.cc+12*(settingBar3.getProgress()-2);*/
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {


                    }
                });

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                rootView = inflater.inflate(R.layout.about, container, false);
            }
            return rootView;
        }


        public int param1 =1, //domyślne parametry w oknie Knobs
        param2 = 2,
        param3 = 3,
        param4 = 4,
        param5 = 5;

        public CharSequence getParamName(int paramNo){
            switch (paramNo){
                case 1: return "modulation";
                case 2: return "volume";
                case 3: return "pan";
                case 4: return "cutoff";
                case 5: return "resonance";
                case 6: return "attack";
                case 7: return "decay";
                case 8: return "sustain";
                case 9: return "release";
                case 10: return "portamento";
                case 11: return "reverb";
            }
            return null;
        }
        public int getParamMidi(int paramNo){
            switch (paramNo){
                case 1: return MIDI.ModulationWheel;
                case 2: return MIDI.ChannelVolume;
                case 3: return MIDI.Pan;
                case 5: return MIDI.Resonance;
                case 4: return MIDI.Cutoff;
                case 6: return MIDI.Attack;
                case 7: return MIDI.Decay;
                case 8: return MIDI.Sustain;
                case 9: return MIDI.Release;
                case 10: return MIDI.PortamentoTime;
                case 11: return MIDI.Reverb;

            }
            return 0;
        }

    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }
        @Override
        public int getCount() {
            return 4;
        }
    }
}


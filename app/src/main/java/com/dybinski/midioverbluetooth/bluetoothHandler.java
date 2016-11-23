package com.dybinski.midioverbluetooth;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.SharedPreferences;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Nikodem Dybiński on 14.06.2016.
 */
public class bluetoothHandler {
    private SharedPreferences globals;
    bluetoothHandler() { //konstruktor
        if (Frontend.wasConnected == false) {
            connectDevice();
            Frontend.wasConnected = true;
        }
    }

    private static BluetoothSocket bluetoothSocket = null;

    public void connectDevice() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); //łączymy się z wbudowanym modułem Bluetooth
        BluetoothDevice MidiModule = bluetoothAdapter.getRemoteDevice("20:13:05:17:34:58"); //łączymy się z modułem MIDI
        try {
            bluetoothSocket = MidiModule.createInsecureRfcommSocketToServiceRecord(UUID.randomUUID());
            Method m = MidiModule.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
            bluetoothSocket = (BluetoothSocket) m.invoke(MidiModule, 1);
            bluetoothSocket.connect(); //połączenie
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void midiProgramChange(int programNo){
        try{
            bluetoothSocket.getOutputStream().write(MIDI.ProgramChange);
            bluetoothSocket.getOutputStream().write(programNo);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void midiMessage(int type, int val1, int val2)
    {


        try{
            int cmd = type + MIDI.channel;
            bluetoothSocket.getOutputStream().write(cmd);
            bluetoothSocket.getOutputStream().write(val1);
            bluetoothSocket.getOutputStream().write(val2);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void testButtonOn(){

        try{

            bluetoothSocket.getOutputStream().write(0x90);
            //  bluetoothSocket.getOutputStream().write(0b0000);
            bluetoothSocket.getOutputStream().write(0x45);
            bluetoothSocket.getOutputStream().write(0x45);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testButtonOff(){

        try{
            bluetoothSocket.getOutputStream().write(0x80);
            bluetoothSocket.getOutputStream().write(0x45);
            bluetoothSocket.getOutputStream().write(0x00);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}

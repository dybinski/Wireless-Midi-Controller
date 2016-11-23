package com.dybinski.midioverbluetooth;


import android.widget.Toast;

/**
 * Created by Nikodem Dybiński on 14.06.2016.
 */
public class MIDI {
    public static int
            InvalidType           = 0x00,    ///< For notifying errors
            NoteOff               = 0x80,    ///< Note Off
            NoteOn                = 0x90,    ///< Note On
            AfterTouchPoly        = 0xA0,    ///< Polyphonic AfterTouch
            ControlChange         = 0xB0,    ///< Control Change / Channel Mode
            ProgramChange         = 0xC0,    ///< Program Change
            AfterTouchChannel     = 0xD0,    ///< Channel (monophonic) AfterTouch
            PitchBend             = 0xE0,    ///< Pitch Bend
            SystemExclusive       = 0xF0,    ///< System Exclusive
            TimeCodeQuarterFrame  = 0xF1,    ///< System Common - MIDI Time Code Quarter Frame
            SongPosition          = 0xF2,    ///< System Common - Song Position Pointer
            SongSelect            = 0xF3,    ///< System Common - Song Select
            TuneRequest           = 0xF6,    ///< System Common - Tune Request
            Clock                 = 0xF8,    ///< System Real Time - Timing Clock
            Start                 = 0xFA,    ///< System Real Time - Start
            Continue              = 0xFB,    ///< System Real Time - Continue
            Stop                  = 0xFC,    ///< System Real Time - Stop
            ActiveSensing         = 0xFE,    ///< System Real Time - Active Sensing
            SystemReset           = 0xFF,    ///< System Real Time - System Reset

    // High resolution Continuous Controllers MSB (+32 for LSB) ----------------
            BankSelect                  = 0,
            ModulationWheel             = 1,
            BreathController            = 2,
    // CC3 undefined
            FootController              = 4,
            PortamentoTime              = 5,
            DataEntry                   = 6,
            ChannelVolume               = 7,
            Balance                     = 8,
    // CC9 undefined
            Pan                         = 10,
            ExpressionController        = 11,
            EffectControl1              = 12,
            EffectControl2              = 13,
    // CC14 undefined
    // CC15 undefined
    GeneralPurposeController1   = 16,
            GeneralPurposeController2   = 17,
            GeneralPurposeController3   = 18,
            GeneralPurposeController4   = 19,

    // Switches ----------------------------------------------------------------
            SustainSwitch               = 64,
            Portamento                  = 65,
            Sostenuto                   = 66,
            SoftPedal                   = 67,
            Legato                      = 68,
            Cutoff                      = 69,

    // Low resolution continuous controllers -----------------------------------
            Resonance                   = 70,   ///< Synth: Sound Variation   FX: Exciter On/Off
            SoundController2            = 71,   ///< Synth: Resonance  FX: Compressor On/Off
            SoundController3            = 72,   ///< Synth: Release Time      FX: Distortion On/Off
            SoundController4            = 73,   ///< Synth: Attack Time       FX: EQ On/Off
            SoundController5            = 74,   ///< Synth: Cutoff            FX: Expander On/Off
            SoundController6            = 75,   ///< Synth: Decay Time        FX: Reverb On/Off
            SoundController7            = 76,   ///< Synth: Vibrato Rate      FX: Delay On/Off
            SoundController8            = 77,   ///< Synth: Vibrato Depth     FX: Pitch Transpose On/Off
            SoundController9            = 78,   ///< Synth: Vibrato Delay     FX: Flange/Chorus On/Off
            SoundController10           = 79,   ///< Synth: Undefined         FX: Special Effects On/Off
            GeneralPurposeController5   = 80,
            GeneralPurposeController6   = 81,
            GeneralPurposeController7   = 82,
            GeneralPurposeController8   = 83,
            PortamentoControl           = 84,
    // CC85 to CC90 undefined
            Effects1                    = 91,   ///< Reverb send level
            Effects2                    = 92,   ///< Tremolo depth
            Effects3                    = 93,   ///< Chorus send level
            Reverb                      = 94,   ///< Celeste depth
            Effects5                    = 95,   ///< Phaser depth

            Attack                      = 101,
            Decay                       = 102,
            Sustain                     = 103,
            Release                     = 106,

    // Channel Mode messages ---------------------------------------------------
            AllSoundOff                 = 120,
            ResetAllControllers         = 121,
            LocalControl                = 122,
            AllNotesOff                 = 123,
            OmniModeOff                 = 124,
            OmniModeOn                  = 125,
            MonoModeOn                  = 126,
            PolyModeOn                  = 127,




            c                            = 60,
            cis                          = 61,
            d                            = 62,
            dis                          = 63,
            e                            = 64,
            f                            = 65,
            fis                          = 66,
            g                            = 67,
            gis                          = 68,
            a                            = 69,
            ais                          = 70,
            h                            = 71,
            cc                           = 72,


            channel                      = 0;




}

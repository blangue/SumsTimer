/*
 * *
 *  * Created by bastien on 16/06/2022 20:14
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 16/06/2022 20:03
 *
 */

package com.example.sumstimer.Types;

import com.example.sumstimer.R;

import java.util.List;

public enum Sum {
    FLASH, TELEPORT, HEAL, GHOST, BARRIER, EXHAUST, SMITE, CLEANSE, IGNITE;

    public int getIcon(){
        int ret = 0;
        switch (this){
            case HEAL:
                ret = R.drawable.heal__28summoner_spell_29;
                break;
            case GHOST:
                ret = R.drawable.ghost__28summoner_spell_29;
                break;
            case SMITE:
                ret = R.drawable.smite__28summoner_spell_29;
                break;
            case IGNITE:
                ret = R.drawable.ignite__28summoner_spell_29;
                break;
            case BARRIER:
                ret = R.drawable.barrier__summoner_spell_;
                break;
            case CLEANSE:
                ret = R.drawable.cleanse__28summoner_spell_29;
                break;
            case EXHAUST:
                ret = R.drawable.exhaust__28summoner_spell_29;
                break;
            case TELEPORT:
                ret = R.drawable.teleport__28summoner_spell_29;
                break;
            case FLASH:
            default:
                ret = R.drawable.flash__28summoner_spell_29;
        }
        return ret;
    }

    public int getCD() {
        int ret; // seconds
        switch (this){
            case HEAL:
                ret = 240;
                break;
            case GHOST:
                ret = 210;
                break;
            case SMITE:
                ret = 90;
                break;
            case IGNITE:
                ret = 180;
                break;
            case BARRIER:
                ret = 180;
                break;
            case CLEANSE:
                ret = 210;
                break;
            case EXHAUST:
                ret = 210;
                break;
            case TELEPORT:
                ret = 360;
                break;
            case FLASH:
            default:
                ret = 300;
        }
        return ret;
    }

    public static Sum fromIconToSum(int drawableID) {
        Sum ret; // seconds
        switch (drawableID){
            case R.drawable.heal__28summoner_spell_29:
                ret = HEAL;
                break;
            case R.drawable.ghost__28summoner_spell_29:
                ret = GHOST;
                break;
            case R.drawable.smite__28summoner_spell_29:
                ret = SMITE;
                break;
            case R.drawable.ignite__28summoner_spell_29:
                ret = IGNITE;
                break;
            case R.drawable.barrier__summoner_spell_:
                ret = BARRIER;
                break;
            case R.drawable.cleanse__28summoner_spell_29:
                ret = CLEANSE;
                break;
            case R.drawable.exhaust__28summoner_spell_29:
                ret = EXHAUST;
                break;
            case R.drawable.teleport__28summoner_spell_29:
                ret = TELEPORT;
                break;
            case R.drawable.flash__28summoner_spell_29:
            default:
                ret = FLASH;
        }
        return ret;
    }
}


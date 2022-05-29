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
}


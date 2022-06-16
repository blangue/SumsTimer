/*
 * *
 *  * Created by bastien on 16/06/2022 20:14
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 16/06/2022 20:03
 *
 */

package com.example.sumstimer;

import static com.example.sumstimer.Types.Lane.LaneType.*;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sumstimer.Types.Lane;

public class MyModel extends ViewModel {
    private MutableLiveData<Lane> top, jgl, mid, sup, bot;

    public LiveData<Lane> getTop() {
        if(top == null){
            top = new MutableLiveData<Lane>(new Lane(TOP));
        }
        return top;
    }

    public LiveData<Lane> getJgl() {
        if(jgl == null){
            jgl = new MutableLiveData<Lane>(new Lane(JUNGLE));
        }
        return jgl;
    }

    public LiveData<Lane> getMid() {
        if(mid == null){
            mid = new MutableLiveData<Lane>(new Lane(MID));
        }
        return mid;
    }

    public LiveData<Lane> getSup() {
        if(sup == null){
            sup = new MutableLiveData<Lane>(new Lane(SUPPORT));
        }
        return sup;
    }

    public LiveData<Lane> getBot() {
        if(bot == null){
            bot = new MutableLiveData<Lane>(new Lane(BOTTOM));
        }
        return bot;
    }

}

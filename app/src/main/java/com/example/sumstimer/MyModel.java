package com.example.sumstimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sumstimer.Types.Lane;

public class MyModel extends ViewModel {
    private MutableLiveData<Lane> top, jgl, mid, sup, bot;

    public LiveData<Lane> getTop() {
        if(top == null){
            top = new MutableLiveData<Lane>(new Lane());
        }
        return top;
    }

    public LiveData<Lane> getJgl() {
        if(jgl == null){
            jgl = new MutableLiveData<Lane>(new Lane());
        }
        return jgl;
    }

    public LiveData<Lane> getMid() {
        if(mid == null){
            mid = new MutableLiveData<Lane>(new Lane());
        }
        return mid;
    }

    public LiveData<Lane> getSup() {
        if(sup == null){
            sup = new MutableLiveData<Lane>(new Lane());
        }
        return sup;
    }

    public LiveData<Lane> getBot() {
        if(bot == null){
            bot = new MutableLiveData<Lane>(new Lane());
        }
        return bot;
    }

}

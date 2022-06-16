/*
 * *
 *  * Created by bastien on 16/06/2022 20:14
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 16/06/2022 20:03
 *
 */

package com.example.sumstimer.Types;

import android.content.Context;
import android.media.Image;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.sumstimer.R;

public class SumImage {
    public Sum sum;
    public CountDownTimer timer;
    public ImageView image;
    public TextView text;
    public boolean isFinished = false;

    public SumImage(Context context) {
        this.sum = Sum.FLASH;
        this.image = new ImageView(context);
    }
}

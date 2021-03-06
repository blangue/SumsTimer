/*
 * *
 *  * Created by bastien on 16/06/2022 20:14
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 16/06/2022 20:03
 *
 */

package com.example.sumstimer.Types;

public class Lane {
    public enum LaneType {TOP, JUNGLE, MID, SUPPORT, BOTTOM}
    LaneType laneType;
    Sum sum1, sum2;

    public Lane() {
        laneType = LaneType.TOP;
        sum1 = sum2 = Sum.FLASH;
    }

    public Lane(LaneType laneType) {
        this.laneType = laneType;
        sum1 = sum2 = Sum.FLASH;
    }

    public LaneType getLaneType() {
        return laneType;
    }

    public void setLaneType(LaneType laneType) {
        this.laneType = laneType;
    }

    public Sum getSum1() {
        return sum1;
    }

    public void setSum1(Sum sum1) {
        this.sum1 = sum1;
    }

    public Sum getSum2() {
        return sum2;
    }

    public void setSum2(Sum sum2) {
        this.sum2 = sum2;
    }
}

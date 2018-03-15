package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import android.drm.DrmStore;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ICastingTime
{
    ActionsEnum getAction();
    void setAction(ActionsEnum action);
    String getInterval();//For casting times longer than a single round, this can be set as minutes, hours, day, etc.
    void setInterval(String interval);
    int getNumberOfActions();//This is the number of actions, rounds, intervals the spell takes to cast (i.e. 3 full rounds, 1 hour, 2 days, etc)
    void setNumberOfActions(int numberOfActions);
}

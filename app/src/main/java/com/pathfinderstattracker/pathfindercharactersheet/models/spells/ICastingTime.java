package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ICastingTime
{
    ActionsEnum Action = ActionsEnum.Free;
    String Interval = null; //Interval here is minutes, hours, days, etc
    int Period = 0; //This then is the actual number that is applied to Interval
}

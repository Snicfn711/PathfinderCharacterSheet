package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class CastingTime implements ICastingTime
{
    public ActionsEnum Action;
    public String Interval;
    public int Period;
}

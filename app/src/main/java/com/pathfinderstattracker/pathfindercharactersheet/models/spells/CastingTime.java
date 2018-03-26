package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class CastingTime implements ICastingTime
{

    private ActionsEnum Action;
    private String Interval;
    private int NumberOfActions;

    //region Getters and Setters
    @Override
    public ActionsEnum getAction()
    {
        return Action;
    }

    @Override
    public void setAction(ActionsEnum action)
    {
        Action = action;
    }

    @Override
    public String getInterval()
    {
        return Interval;
    }

    @Override
    public void setInterval(String interval)
    {
        Interval = interval;
    }

    @Override
    public int getNumberOfActions()
    {
        return NumberOfActions;
    }

    @Override
    public void setNumberOfActions(int numberOfActions)
    {
        NumberOfActions = numberOfActions;
    }
    //endregion

    public CastingTime()
    {
        //Default Constructor
    }

    public CastingTime(ActionsEnum action, String interval, int numberOfActions)
    {
        setAction(action);
        setInterval(interval);
        setNumberOfActions(numberOfActions);
    }

    @Override
    public String toString()
    {
        if(Action == ActionsEnum.More)
        {
            return Integer.toString(NumberOfActions) + " " + Interval;
        }
        else
        {
            return Action.toString() + " Action";
        }
    }
}

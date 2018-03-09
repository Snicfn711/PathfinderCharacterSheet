package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public class Penalty implements IPenalty
{
    private Object objectAffected;
    private double value;
    private String conditions;
    private Object source;

    //region Getters and Setters
    @Override
    public Object getObjectAffected()
    {
        return objectAffected;
    }

    @Override
    public void setObjectAffected(Object objectAffected)
    {
        this.objectAffected=objectAffected;
    }

    @Override
    public double getValue()
    {
        return value;
    }

    @Override
    public void setValue(double value)
    {
        this.value = value;
    }

    @Override
    public String getConditions()
    {
        return conditions;
    }

    @Override
    public void setConditions(String conditions)
    {
        this.conditions = conditions;
    }

    @Override
    public Object getSource()
    {
        return source;
    }

    @Override
    public void setSource(Object source)
    {
        this.source = source;
    }
    //endregion

    public Penalty()
    {
        //Default Constructor
    }

    public Penalty(Object objectAffected, double value, String conditions, Object source)
    {
        setObjectAffected(objectAffected);
        setValue(value);
        setConditions(conditions);
        setSource(source);
    }
}

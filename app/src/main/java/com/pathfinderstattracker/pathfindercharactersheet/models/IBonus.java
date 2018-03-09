package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public interface IBonus
{
    Object getObjectAffected();
    void setObjectAffected(Object objectAffected);
    double getValue();
    void setValue(double value);
    String getConditions();
    void setConditions(String conditions);
    Object getSource();
    void setSource(Object source);
}

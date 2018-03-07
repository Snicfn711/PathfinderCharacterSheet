package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IItem
{
    double getCost();
    void setCost(double cost); //Measured in Gold, with silver and copper coming after the decimal
    double getWeightAtMediumSize();
    void setWeightAtMediumSize(double weightAtMediumSize);//Measured in lbs
    String getName();
    void setName(String name);
}

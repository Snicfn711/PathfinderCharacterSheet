package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import java.util.UUID;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IItem extends Comparable<IItem>
{
    UUID getItemID();
    void setItemID(UUID itemID);
    double getCost();
    void setCost(double cost); //Measured in Gold, with silver and copper coming after the decimal
    double getWeightAtMediumSize();
    void setWeightAtMediumSize(double weightAtMediumSize);//Measured in lbs
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
}

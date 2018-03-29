package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import android.support.annotation.NonNull;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class ReusableMundaneItem extends Item
{
    private String name;
    private String description;
    private double cost;
    private double weightAtMediumSize;

    //region Getters and Setters
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public double getCost()
    {
        return cost;
    }

    @Override
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public double getWeightAtMediumSize()
    {
        return weightAtMediumSize;
    }

    @Override
    public void setWeightAtMediumSize(double weightAtMediumSize)
    {
        this.weightAtMediumSize = weightAtMediumSize;
    }

    public String getDescription()
    {
        return  description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    //endregion

    public ReusableMundaneItem()
    {
        //Default constructor
    }

    public ReusableMundaneItem(String name, String description, double cost, double weightAtMediumSize)
    {
       setName(name);
       setDescription(description);
       setCost(cost);
       setWeightAtMediumSize(weightAtMediumSize);
    }
}

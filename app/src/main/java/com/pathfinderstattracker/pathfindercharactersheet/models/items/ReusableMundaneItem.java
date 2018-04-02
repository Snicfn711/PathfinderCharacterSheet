package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class ReusableMundaneItem extends AbsItem
{
    private String description;
    private double weightAtMediumSize;

    //region Getters and Setters
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

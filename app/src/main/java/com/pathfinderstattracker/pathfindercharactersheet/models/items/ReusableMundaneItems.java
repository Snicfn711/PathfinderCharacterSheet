package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class ReusableMundaneItems implements IItem
{
    private String name;
    private String effect;
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

    public String getEffect()
    {
        return  effect;
    }

    public void setEffect(String effect)
    {
        this.effect = effect;
    }
    //endregion

    public ReusableMundaneItems()
    {
        //Default constructor
    }

    public ReusableMundaneItems(String name, String effect, double cost, double weightAtMediumSize)
    {
       setName(name);
       setEffect(effect);
       setCost(cost);
       setWeightAtMediumSize(weightAtMediumSize);
    }
}

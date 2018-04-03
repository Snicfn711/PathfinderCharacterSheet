package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class ReusableMundaneItem extends AbsItem
{
    public ReusableMundaneItem()
    {
        //Default constructor
    }

    public ReusableMundaneItem(String name, String description, double cost, double weightAtMediumSize)
    {
       super(cost, weightAtMediumSize, name, description);
    }
}

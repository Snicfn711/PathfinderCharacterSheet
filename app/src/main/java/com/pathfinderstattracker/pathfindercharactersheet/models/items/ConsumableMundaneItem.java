package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class ConsumableMundaneItem extends AbsItem
{
    public ConsumableMundaneItem()
    {
        //Default constructor
    }

    public ConsumableMundaneItem(String name, String description, double cost, double weightAtMediumSize)
    {
        super(cost, weightAtMediumSize, name, description);
    }
}

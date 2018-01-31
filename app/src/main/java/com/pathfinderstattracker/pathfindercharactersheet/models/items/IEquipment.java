package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IEquipment extends IItem
{
    double weight = 0;//This represents the item's weight at medium size
    SizeCategoryEnum sizeCategory = SizeCategoryEnum.Medium;
    boolean isMagic = false;
}

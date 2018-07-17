package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IEquipment extends IItem
{
    SizeCategoryEnum getSizeCategory();
    void setSizeCategory(SizeCategoryEnum sizeCategory);
    boolean isMagic();
    void setIsMagic(boolean isMagic);
    boolean isFragile();
    void setIsFragile(boolean isFragile);
    int getMagicBonus();
    void setMagicBonus(int magicBonus);
}

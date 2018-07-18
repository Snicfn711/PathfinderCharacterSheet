package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IArmor extends IProtection
{
    //The default for maximum speed is unbounded, so we'll represent that here with a null value
    Integer getMaxSpeed();
    void setMaxSpeed(Integer maxSpeed);
    ArmorWeightCategoryEnum getWeightCategory();
    void setWeightCategory(ArmorWeightCategoryEnum weightCategory);
    List<IArmorEnchantment> getEnchantments();
}

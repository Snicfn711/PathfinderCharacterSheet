package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public interface IWondrousItems extends IEquipment
{
    ArcaneAura getAura();
    void setAura(ArcaneAura aura);
    BodySlotsEnum getBodySlot();
    void setBodySlot(BodySlotsEnum bodySlot);
    Integer getCasterLevel();
    void setCasterLevel(Integer casterLevel);
    Integer getACBonus();
    void setACBonus(Integer acBonus);
    ArmorTypesEnum getArmorType();
    void setArmorType(ArmorTypesEnum armorType);
}

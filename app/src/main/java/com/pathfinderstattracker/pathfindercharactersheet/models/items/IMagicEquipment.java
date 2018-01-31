package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public interface IMagicEquipment extends IItem
{
    ArcaneAura Aura = null;
    BodySlotsEnum BodySlot = BodySlotsEnum.Body;
    IAbility[] Abilities = null;
    Integer CasterLevel = 0;
}

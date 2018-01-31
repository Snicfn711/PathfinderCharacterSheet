package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public class MagicEquipment implements IMagicEquipment
{
    public double Cost;
    public double Weight;
    public ArcaneAura Aura;
    public BodySlotsEnum BodySlot;
    public Ability[] Abilities;
    public Integer CasterLevel;
}

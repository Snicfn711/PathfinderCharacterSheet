package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public class MagicEquipment extends AbsItem implements IMagicEquipment
{

    private ArcaneAura aura;
    private BodySlotsEnum bodySlot;
    private Ability[] abilities;
    private Integer casterLevel;

    //region Getters and Setters
    public ArcaneAura getAura()
    {
        return aura;
    }

    public void setAura(ArcaneAura aura)
    {
        this.aura = aura;
    }

    public BodySlotsEnum getBodySlot()
    {
        return bodySlot;
    }

    public void setBodySlot(BodySlotsEnum bodySlot)
    {
        this.bodySlot = bodySlot;
    }

    public Ability[] getAbilities()
    {
        return abilities;
    }

    public void setAbilities(Ability[] abilities)
    {
        this.abilities = abilities;
    }

    public Integer getCasterLevel()
    {
        return casterLevel;
    }

    public void setCasterLevel(Integer casterLevel)
    {
        this.casterLevel = casterLevel;
    }
    //endregion

    public MagicEquipment()
    {
        //Default constructor
    }

    public MagicEquipment(String name, double cost, double weightAtMediumSize, ArcaneAura aura, BodySlotsEnum bodySlot, Ability[] abilities, Integer casterLevel)
    {
        setName(name);
        setCost(cost);
        setWeightAtMediumSize(weightAtMediumSize);
        setAura(aura);
        setBodySlot(bodySlot);
        setAbilities(abilities);
        setCasterLevel(casterLevel);
    }
}

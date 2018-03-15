package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class SpellArea implements ISpellArea
{
    private SpellAreaEnum SpellArea;
    private Integer NumberOfFeetInArea;

    @Override
    public SpellAreaEnum getSpellArea()
    {
        return SpellArea;
    }

    @Override
    public void setSpellArea(SpellAreaEnum spellArea)
    {
        SpellArea = spellArea;
    }

    @Override
    public Integer getNumberOfFeetInArea()
    {
        return NumberOfFeetInArea;
    }

    @Override
    public void setNumberOfFeetInArea(Integer numberOfFeetInArea)
    {
        NumberOfFeetInArea = numberOfFeetInArea;
    }
}

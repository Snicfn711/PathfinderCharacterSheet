package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class SpellArea implements ISpellArea
{
    private SpellAreaEnum SpellArea;
    private Integer NumberOfFeetInArea;

    //region Getters and Setters
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
    //endregion


    public SpellArea()
    {
        //Default Constructor
    }

    public SpellArea(SpellAreaEnum spellArea, Integer numberOfFeetInArea)
    {
        setSpellArea(spellArea);
        setNumberOfFeetInArea(numberOfFeetInArea);
    }

    @Override
    public String toString()
    {
        return Integer.toString(NumberOfFeetInArea) + " Foot " + SpellArea.toString();
    }

}

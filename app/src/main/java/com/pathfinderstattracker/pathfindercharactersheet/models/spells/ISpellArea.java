package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ISpellArea
{
    SpellAreaEnum getSpellArea();
    void setSpellArea(SpellAreaEnum spellArea);
    Integer getNumberOfFeetInArea();
    void setNumberOfFeetInArea(Integer numberOfFeetInArea);
}

package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ISpellDuration
{
    SpellDurationEnum getSpellDuration();
    void setSpellDuration(SpellDurationEnum spellDuration);
    Integer getNumberOfIncrements();
    void setNumberOfIncrements(Integer numberOfIncrements);
    String getTimeIncrement();
    void setTimeIncrement(String timeIncrement);
}

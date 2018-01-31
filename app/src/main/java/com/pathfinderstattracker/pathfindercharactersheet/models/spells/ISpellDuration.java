package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ISpellDuration
{
    SpellDurationEnum DurationEnum = SpellDurationEnum.Instant;
    int Frequency = 0;
    String TimeIncrement = null;
}

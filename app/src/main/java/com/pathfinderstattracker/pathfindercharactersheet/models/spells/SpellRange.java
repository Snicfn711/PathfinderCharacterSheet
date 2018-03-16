package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */
/*
Like its interface, SpellRange wasn't doing anything SpellRangeEnum couldn't do instead
 */
@Deprecated
public class SpellRange implements ISpellRange
{
    SpellRangeEnum RangeEnum;
    int Value;
}

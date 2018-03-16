package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */
/*
ISpellRange doesn't do anything the SpellRangeEnum wasn't already doing, so use that instead
 */
@Deprecated
public interface ISpellRange
{
    SpellRangeEnum RangeEnum = SpellRangeEnum.Close;
    int Value = 0;
}

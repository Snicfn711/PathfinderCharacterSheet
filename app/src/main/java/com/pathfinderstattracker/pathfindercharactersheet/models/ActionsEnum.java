package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/2/2018.
 */

public enum ActionsEnum
{
    Immediate,
    Standard,
    Move,
    Swift,
    Free,
    FullRound,
    More //More here means an action that isn't measure in combat time, but rather in real time (i.e. minutes, hours, days, etc). It's likely only going to be applied to spells
}

package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ICombatManeuver
{
    int CombatManeuverCheck = 0;
    int CombatManeuverDefense = 0;
    void setCombatManeuverCheck(int combatManeuverCheck);
    int getCombatManeuverCheck();
    void setCombatManeuverDefense(int combatManeuverDefense);
    int getCombatManeuverDefense();
}

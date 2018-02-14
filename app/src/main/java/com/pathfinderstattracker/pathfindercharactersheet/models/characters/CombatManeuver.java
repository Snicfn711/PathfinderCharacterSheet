package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class CombatManeuver implements ICombatManeuver
{
    int CombatManeuverCheck;
    int CombatManeuverDefense;

    public int getCombatManeuverCheck()
    {
        return CombatManeuverCheck;
    }

    public void setCombatManeuverCheck(int combatManeuverCheck)
    {
        CombatManeuverCheck = combatManeuverCheck;
    }

    public int getCombatManeuverDefense()
    {
        return CombatManeuverDefense;
    }

    public void setCombatManeuverDefense(int combatManeuverDefense)
    {
        CombatManeuverDefense = combatManeuverDefense;
    }

    public CombatManeuver()
    {
        //Default Constructor
    }

    public CombatManeuver(int combatManeuverCheck, int combatManeuverDefense)
    {
        setCombatManeuverCheck(combatManeuverCheck);
        setCombatManeuverDefense(combatManeuverDefense);
    }
}

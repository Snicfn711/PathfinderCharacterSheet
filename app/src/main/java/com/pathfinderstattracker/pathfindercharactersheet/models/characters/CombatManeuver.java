package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class CombatManeuver implements ICombatManeuver
{
    int combatManeuverCheck;
    int combatManeuverDefense;

    public int getCombatManeuverCheck()
    {
        return combatManeuverCheck;
    }

    public void setCombatManeuverCheck(int combatManeuverCheck)
    {
        this.combatManeuverCheck = combatManeuverCheck;
    }

    public int getCombatManeuverDefense()
    {
        return combatManeuverDefense;
    }

    public void setCombatManeuverDefense(int combatManeuverDefense)
    {
        this.combatManeuverDefense = combatManeuverDefense;
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

    @Override
    public String toString()
    {
        //There shouldn't be any cases where the entire object needs to be presented as a string, except when converting for the database, so we don't need any CMD/CMB labeling
        return Integer.toString(combatManeuverCheck) + "/"+ Integer.toString(combatManeuverDefense);
    }
}

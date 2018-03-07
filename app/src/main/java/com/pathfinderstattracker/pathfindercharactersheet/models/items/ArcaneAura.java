package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AuraStrengthEnum;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public class ArcaneAura
{
    private ArcaneSchoolEnum auraSchool;
    private AuraStrengthEnum auraStrength;

    public ArcaneSchoolEnum getAuraSchool()
    {
        return auraSchool;
    }

    public void setAuraSchool(ArcaneSchoolEnum auraSchool)
    {
        this.auraSchool = auraSchool;
    }

    public AuraStrengthEnum getAuraStrength()
    {
        return auraStrength;
    }

    public void setAuraStrength(AuraStrengthEnum auraStrength)
    {
        this.auraStrength = auraStrength;
    }

    public ArcaneAura()
    {
        //Default constructor
    }

    public ArcaneAura(ArcaneSchoolEnum auraSchool, AuraStrengthEnum auraStrength)
    {
        setAuraSchool(auraSchool);
        setAuraStrength(auraStrength);
    }
}

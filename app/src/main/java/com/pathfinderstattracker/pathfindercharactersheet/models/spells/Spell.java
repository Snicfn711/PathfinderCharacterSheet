package com.pathfinderstattracker.pathfindercharactersheet.models.spells;


import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class Spell implements ISpell
{
    public ArcaneSchoolEnum School;
    public DescriptorEnum[] Descriptors;
    public String SavingThrow; //This should be okay as a string, as it's just telling the player which save is being targeted and what happens on a successful save
    public String MaterialComponents; //Also serves as a HasMaterial surrogate field
    public boolean HasVerbal;
    public boolean HasSomatic;
    public boolean HasFocus;
    public boolean HasDivineFocus;
    public ICastingTime CastingTime;
    public ISpellRange Range;
    public String Target; //May need a SpellTargetEnum or class for this
    public ISpellDuration Duration;
    public ISpellArea Area;
    public String SourceClass; //Replace with Class object
}

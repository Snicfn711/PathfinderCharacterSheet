package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ISpell
{
    ArcaneSchoolEnum School = ArcaneSchoolEnum.Abjuration;
    DescriptorEnum[] Descriptors = null;
    String SavingThrow = null; //This should be okay as a string, as it's just telling the player which save is being targeted and what happens on a successful save
    String MaterialComponents = null; //Also serves as a HasMaterial surrogate field
    boolean HasVerbal = false;
    boolean HasSomatic = false;
    boolean HasFocus = false;
    boolean HasDivineFocus = false;
    ICastingTime CastingTime = null;
    ISpellRange Range = null;
    String Target = null; //May need a SpellTargetEnum or class for this
    ISpellDuration Duration = null;
    ISpellArea Area = null;
    String SourceClass = null; //Replace with Class object
}

package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.classes.IClass;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public interface ISpell
{
    ArcaneSchoolEnum getSchool();

    void setSchool(ArcaneSchoolEnum school);

    DescriptorEnum[] getDescriptors();

    void setDescriptors(DescriptorEnum[] descriptors);

    String getSavingThrow();

    void setSavingThrow(String savingThrow);//This should be okay as a string, as it's just telling the player which save is being targeted and what happens on a successful save

    String getMaterialComponents();//Also serves as a HasMaterial surrogate field

    void setMaterialComponents(String materialComponents);

    boolean hasVerbalComponents();

    void setHasVerbalComponents(boolean hasVerbal);

    boolean hasSomaticComponents();

    void setHasSomaticComponents(boolean hasSomaticComponents);

    boolean usesFocus();

    void setUsesFocus(boolean usesFocus);

    boolean usesDivineFocus();

    void setUsesDivineFocus(boolean usesDivineFocus);

    ICastingTime getCastingTime();

    void setCastingTime(ICastingTime castingTime);

    SpellRangeEnum getSpellRange();

    void setSpellRange(SpellRangeEnum spellRange);

    String getTarget();

    void setTarget(String target);

    ISpellDuration getSpellDuration();

    void setSpellDuration(ISpellDuration spellDuration);

    ISpellArea getSpellArea();

    void setSpellArea(ISpellArea spellArea);

    IClass getSourceClass();

    void setSourceClass(IClass sourceClass);

    String getFullDescription();

    void setFullDescription(String fullDescription);

    String getShortDescription();

    void setShortDescription(String shortDescription);

    Integer getMaximumNumberOfDice();

    void setMaximumNumberOfDice(Integer maximumNumberOfDice);

    Damage getDamageIncrements();

    void setDamageIncrements(Damage damageIncrements);

    Integer getCasterLevelsPerIncrement();

    void setCasterLevelsPerIncrement(Integer casterLevelsPerIncrement);

    boolean targetsSpellResistance();

    void setTargetsSpellResistance(boolean targetsSpellResistance);

    String getSpellName();

    void setSpellName(String spellName);
}

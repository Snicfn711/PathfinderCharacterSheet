package com.pathfinderstattracker.pathfindercharactersheet.models.spells;


import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.classes.ICharacterClass;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class Spell implements ISpell
{
    private String SpellName;
    private ArcaneSchoolEnum School;
    private DescriptorEnum[] Descriptors;
    private String SavingThrow; //This should be okay as a string, as it's just telling the player which save is being targeted and what happens on a successful save
    private String MaterialComponents; //Also serves as a HasMaterial surrogate field
    private boolean HasVerbal;
    private boolean HasSomatic;
    private boolean HasFocus;
    private boolean HasDivineFocus;
    private ICastingTime CastingTime;
    private SpellRangeEnum Range;
    private String Target;
    private ISpellDuration Duration;
    private ISpellArea Area;
    private ICharacterClass SourceClass;
    private String FullDescription;
    private String ShortDescription;
    private Integer MaximumNumberOfDice;
    private Damage DamageIncrements;
    private Integer CasterLevelsPerIncrement;
    private boolean targetsSpellResistance;
    private int spellLevel;

    //region Getters and Setters
    @Override
    public String getSpellName()
    {
        return SpellName;
    }

    @Override
    public void setSpellName(String spellName)
    {
        SpellName = spellName;
    }
    @Override
    public ArcaneSchoolEnum getSchool()
    {
        return School;
    }

    @Override
    public void setSchool(ArcaneSchoolEnum school)
    {
        School = school;
    }

    @Override
    public DescriptorEnum[] getDescriptors()
    {
        return Descriptors;
    }

    @Override
    public void setDescriptors(DescriptorEnum[] descriptors)
    {
        Descriptors = descriptors;
    }

    @Override
    public String getSavingThrow()
    {
        return SavingThrow;
    }

    @Override
    public void setSavingThrow(String savingThrow)
    {
        SavingThrow = savingThrow;
    }

    @Override
    public String getMaterialComponents()
    {
        return MaterialComponents;
    }

    @Override
    public void setMaterialComponents(String materialComponents)
    {
        MaterialComponents = materialComponents;
    }

    @Override
    public boolean hasVerbalComponents()
    {
        return HasVerbal;
    }

    @Override
    public void setHasVerbalComponents(boolean hasVerbal)
    {
        HasVerbal = hasVerbal;
    }

    @Override
    public boolean hasSomaticComponents()
    {
        return HasSomatic;
    }

    @Override
    public void setHasSomaticComponents(boolean hasSomatic)
    {
        HasSomatic = hasSomatic;
    }

    @Override
    public boolean usesFocus()
    {
        return HasFocus;
    }

    @Override
    public void setUsesFocus(boolean hasFocus)
    {
        HasFocus = hasFocus;
    }

    @Override
    public boolean usesDivineFocus()
    {
        return HasDivineFocus;
    }

    @Override
    public void setUsesDivineFocus(boolean hasDivineFocus)
    {
        HasDivineFocus = hasDivineFocus;
    }

    @Override
    public ICastingTime getCastingTime()
    {
        return CastingTime;
    }

    @Override
    public void setCastingTime(ICastingTime castingTime)
    {
        CastingTime = castingTime;
    }

    @Override
    public SpellRangeEnum getSpellRange()
    {
        return Range;
    }

    @Override
    public void setSpellRange(SpellRangeEnum range)
    {
        Range = range;
    }

    @Override
    public String getTarget()
    {
        return Target;
    }

    @Override
    public void setTarget(String target)
    {
        Target = target;
    }

    @Override
    public ISpellDuration getSpellDuration()
    {
        return Duration;
    }


    @Override
    public void setSpellDuration(ISpellDuration duration)
    {
        Duration = duration;
    }

    @Override
    public ISpellArea getSpellArea()
    {
        return Area;
    }

    @Override
    public void setSpellArea(ISpellArea area)
    {
        Area = area;
    }

    @Override
    public ICharacterClass getSourceClass()
    {
        return SourceClass;
    }

    @Override
    public void setSourceClass(ICharacterClass sourceClass)
    {
        SourceClass = sourceClass;
    }

    @Override
    public String getFullDescription()
    {
        return FullDescription;
    }

    @Override
    public void setFullDescription(String fullDescription)
    {
        FullDescription = fullDescription;
    }

    @Override
    public String getShortDescription()
    {
        return ShortDescription;
    }

    @Override
    public void setShortDescription(String shortDescription)
    {
        ShortDescription = shortDescription;
    }

    @Override
    public Integer getMaximumNumberOfDice()
    {
        return MaximumNumberOfDice;
    }

    @Override
    public void setMaximumNumberOfDice(Integer maximumNumberOfDice)
    {
        MaximumNumberOfDice = maximumNumberOfDice;
    }

    @Override
    public Damage getDamageIncrements()
    {
        return DamageIncrements;
    }

    @Override
    public void setDamageIncrements(Damage damageIncrements)
    {
        DamageIncrements = damageIncrements;
    }

    @Override
    public Integer getCasterLevelsPerIncrement()
    {
        return CasterLevelsPerIncrement;
    }

    @Override
    public void setCasterLevelsPerIncrement(Integer casterLevelsPerIncrement)
    {
        CasterLevelsPerIncrement = casterLevelsPerIncrement;
    }

    @Override
    public boolean targetsSpellResistance()
    {
        return targetsSpellResistance;
    }

    @Override
    public void setTargetsSpellResistance(boolean targetsSpellResistance)
    {
        this.targetsSpellResistance = targetsSpellResistance;
    }

    @Override
    public int getSpellLevel() {return spellLevel;}

    @Override
    public void setSpellLevel(int spellLevel)
    {this.spellLevel = spellLevel;}
    //endregion


    public Spell()
    {
        //Default Constructor
    }

    public Spell(String spellName, ArcaneSchoolEnum school, DescriptorEnum[] descriptors, String savingThrow,
                 String materialComponents, boolean hasVerbal, boolean hasSomatic, boolean hasFocus, boolean hasDivineFocus,
                 ICastingTime castingTime, SpellRangeEnum range, String target, ISpellDuration duration, ISpellArea area, ICharacterClass sourceClass,
                 String fullDescription, String shortDescription, Integer maximumNumberOfDice, Damage damageIncrements, Integer casterLevelsPerIncrement,
                 boolean targetsSpellResistance, int spellLevel)
    {
        setSpellName(spellName);
        setSchool(school);
        setDescriptors(descriptors);
        setSavingThrow(savingThrow);
        setMaterialComponents(materialComponents);
        setHasVerbalComponents(hasVerbal);
        setHasSomaticComponents(hasSomatic);
        setUsesFocus(hasFocus);
        setUsesDivineFocus(hasDivineFocus);
        setCastingTime(castingTime);
        setSpellRange(range);
        setTarget(target);
        setSpellDuration(duration);
        setSpellArea(area);
        setSourceClass(sourceClass);
        setFullDescription(fullDescription);
        setShortDescription(shortDescription);
        setMaximumNumberOfDice(maximumNumberOfDice);
        setDamageIncrements(damageIncrements);
        setCasterLevelsPerIncrement(casterLevelsPerIncrement);
        setTargetsSpellResistance(targetsSpellResistance);
        setSpellLevel(spellLevel); //Todo: It might make sense later to associate spell level with the source class, rather than the spell, since multiple classes can cast the same spell, but at different levels.
    }
}

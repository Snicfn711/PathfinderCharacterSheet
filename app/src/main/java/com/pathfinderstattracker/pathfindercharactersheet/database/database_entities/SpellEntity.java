package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.ArcaneSchoolEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.CastingTimeConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.CharacterClassConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.DamageConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SpellAreaConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SpellDescriptorListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SpellDurationConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SpellRangeEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.classes.ICharacterClass;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.DescriptorEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ICastingTime;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellArea;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellRangeEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */
@Entity
@TypeConverters({ArcaneSchoolEnumConverter.class,
                 SpellDescriptorListConverter.class,
                 CastingTimeConverter.class,
                 SpellRangeEnumConverter.class,
                 SpellDurationConverter.class,
                 SpellAreaConverter.class,
                 DamageConverter.class,
                 CharacterClassConverter.class})
public class SpellEntity
{
    @PrimaryKey
    private int spellID;
    @ColumnInfo(name = "spell_name")
    private String SpellName;
    @ColumnInfo(name = "school")
    private ArcaneSchoolEnum School;
    @ColumnInfo(name = "descriptors")
    private List<DescriptorEnum> Descriptors;
    @ColumnInfo(name = "saving_throw")
    private String SavingThrow; //This should be okay as a string, as it's just telling the player which save is being targeted and what happens on a successful save
    @ColumnInfo(name = "material_components")
    private String MaterialComponents; //Also serves as a HasMaterial surrogate field
    @ColumnInfo(name = "has_verbal")
    private boolean HasVerbal;
    @ColumnInfo(name = "has_somatic")
    private boolean HasSomatic;
    @ColumnInfo(name = "has_focus")
    private boolean HasFocus;
    @ColumnInfo(name = "has_divine_focus")
    private boolean HasDivineFocus;
    @ColumnInfo(name = "casting_time")
    private ICastingTime castingTime;
    @ColumnInfo(name = "range")
    private SpellRangeEnum Range;
    @ColumnInfo(name = "target")
    private String Target;
    @ColumnInfo(name = "duration")
    private ISpellDuration Duration;
    @ColumnInfo(name = "area")
    private ISpellArea Area;
    @ColumnInfo(name = "source_class")
    private ICharacterClass SourceClass;
    @ColumnInfo(name = "full_description")
    private String FullDescription;
    @ColumnInfo(name = "short_description")
    private String ShortDescription;
    @ColumnInfo(name = "maximum_number_of_dice")
    private Integer MaximumNumberOfDice;
    @ColumnInfo(name = "damage_increments")
    private Damage DamageIncrements;
    @ColumnInfo(name = "caster_levels_per_increment")
    private Integer CasterLevelsPerIncrement;
    @ColumnInfo(name = "targets_spell_resistance")
    private boolean targetsSpellResistance;
    @ColumnInfo(name = "spell_level")
    private int spellLevel;

    //region Getters and Setters
    public int getSpellID()
    {
        return spellID;
    }

    public void setSpellID(int spellID)
    {
        this.spellID = spellID;
    }

    public String getSpellName()
    {
        return SpellName;
    }

    public void setSpellName(String spellName)
    {
        SpellName = spellName;
    }

    public ArcaneSchoolEnum getSchool()
    {
        return School;
    }

    public void setSchool(ArcaneSchoolEnum school)
    {
        School = school;
    }

    public List<DescriptorEnum> getDescriptors()
    {
        return Descriptors;
    }

    public void setDescriptors(List<DescriptorEnum> descriptors)
    {
        Descriptors = descriptors;
    }

    public String getSavingThrow()
    {
        return SavingThrow;
    }

    public void setSavingThrow(String savingThrow)
    {
        SavingThrow = savingThrow;
    }

    public String getMaterialComponents()
    {
        return MaterialComponents;
    }

    public void setMaterialComponents(String materialComponents)
    {
        MaterialComponents = materialComponents;
    }

    public boolean isHasVerbal()
    {
        return HasVerbal;
    }

    public void setHasVerbal(boolean hasVerbal)
    {
        HasVerbal = hasVerbal;
    }

    public boolean isHasSomatic()
    {
        return HasSomatic;
    }

    public void setHasSomatic(boolean hasSomatic)
    {
        HasSomatic = hasSomatic;
    }

    public boolean isHasFocus()
    {
        return HasFocus;
    }

    public void setHasFocus(boolean hasFocus)
    {
        HasFocus = hasFocus;
    }

    public boolean isHasDivineFocus()
    {
        return HasDivineFocus;
    }

    public void setHasDivineFocus(boolean hasDivineFocus)
    {
        HasDivineFocus = hasDivineFocus;
    }

    public ICastingTime getCastingTime()
    {
        return castingTime;
    }

    public void setCastingTime(ICastingTime castingTime)
    {
        this.castingTime = castingTime;
    }

    public SpellRangeEnum getRange()
    {
        return Range;
    }

    public void setRange(SpellRangeEnum range)
    {
        Range = range;
    }

    public String getTarget()
    {
        return Target;
    }

    public void setTarget(String target)
    {
        Target = target;
    }

    public ISpellDuration getDuration()
    {
        return Duration;
    }

    public void setDuration(ISpellDuration duration)
    {
        Duration = duration;
    }

    public ISpellArea getArea()
    {
        return Area;
    }

    public void setArea(ISpellArea area)
    {
        Area = area;
    }

    public ICharacterClass getSourceClass()
    {
        return SourceClass;
    }

    public void setSourceClass(ICharacterClass sourceClass)
    {
        SourceClass = sourceClass;
    }

    public String getFullDescription()
    {
        return FullDescription;
    }

    public void setFullDescription(String fullDescription)
    {
        FullDescription = fullDescription;
    }

    public String getShortDescription()
    {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        ShortDescription = shortDescription;
    }

    public Integer getMaximumNumberOfDice()
    {
        return MaximumNumberOfDice;
    }

    public void setMaximumNumberOfDice(Integer maximumNumberOfDice)
    {
        MaximumNumberOfDice = maximumNumberOfDice;
    }

    public Damage getDamageIncrements()
    {
        return DamageIncrements;
    }

    public void setDamageIncrements(Damage damageIncrements)
    {
        DamageIncrements = damageIncrements;
    }

    public Integer getCasterLevelsPerIncrement()
    {
        return CasterLevelsPerIncrement;
    }

    public void setCasterLevelsPerIncrement(Integer casterLevelsPerIncrement)
    {
        CasterLevelsPerIncrement = casterLevelsPerIncrement;
    }

    public boolean isTargetsSpellResistance()
    {
        return targetsSpellResistance;
    }

    public void setTargetsSpellResistance(boolean targetsSpellResistance)
    {
        this.targetsSpellResistance = targetsSpellResistance;
    }

    public int getSpellLevel()
    {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel)
    {
        this.spellLevel = spellLevel;
    }
    //endregion
}

package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreChangeConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreChangeListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.BodySlotEnumListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.CreatureTypeConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.SizeCategoryEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.StringListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreChange;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.CreatureType;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IMovement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.ISense;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/30/2018.
 */
@Entity
@TypeConverters({AbilityScoreChangeListConverter.class,
                 BodySlotEnumListConverter.class,
                 SizeCategoryEnumConverter.class,
                 StringListConverter.class,
                 CreatureTypeConverter.class})
public class RaceEntity
{
    @PrimaryKey
    private int raceID;

    @ColumnInfo(name = "hit_dice_size")
    private int HitDiceSize;
    @ColumnInfo(name = "available_equipment_slots")
    private List<BodySlotsEnum> AvailableEquipmentSlots;
    @ColumnInfo(name = "racial_abilities")
    private int RacialAbilities; //There are no races with no abilities (even humans get an extra feat)
    @ColumnInfo(name = "racials_skills")
    private int RacialSkills;
    @ColumnInfo(name = "size")
    private SizeCategoryEnum Size;
    @ColumnInfo(name = "stat_changes")
    private List<AbilityScoreChange> StatChanges;
    @ColumnInfo(name = "available_languages")
    private List<String> AvailableLanguages;
    @ColumnInfo(name = "by_class")
    private boolean ByClass; //This is used to check if Skills and HitDiceSize are replaced by Class versions
    @ColumnInfo(name = "creature_category")
    private CreatureType CreatureCategory;
    @ColumnInfo(name = "movement_types")
    private int MovementTypes;
    @ColumnInfo(name = "senses")
    private int Senses;

    //region Getters and Setters
    public int getRaceID()
    {
        return raceID;
    }

    public void setRaceID(int raceID)
    {
        this.raceID = raceID;
    }

    public int getHitDiceSize()
    {
        return HitDiceSize;
    }

    public void setHitDiceSize(int hitDiceSize)
    {
        HitDiceSize = hitDiceSize;
    }

    public List<BodySlotsEnum> getAvailableEquipmentSlots()
    {
        return AvailableEquipmentSlots;
    }

    public void setAvailableEquipmentSlots(List<BodySlotsEnum> availableEquipmentSlots)
    {
        AvailableEquipmentSlots = availableEquipmentSlots;
    }

    public int getRacialAbilities()
    {
        return RacialAbilities;
    }

    public void setRacialAbilities(int racialAbilities)
    {
        RacialAbilities = racialAbilities;
    }

    public int getRacialSkills()
    {
        return RacialSkills;
    }

    public void setRacialSkills(int racialSkills)
    {
        RacialSkills = racialSkills;
    }

    public SizeCategoryEnum getSize()
    {
        return Size;
    }

    public void setSize(SizeCategoryEnum size)
    {
        Size = size;
    }

    public List<AbilityScoreChange> getStatChanges()
    {
        return StatChanges;
    }

    public void setStatChanges(List<AbilityScoreChange> statChanges)
    {
        StatChanges = statChanges;
    }

    public List<String> getAvailableLanguages()
    {
        return AvailableLanguages;
    }

    public void setAvailableLanguages(List<String> availableLanguages)
    {
        AvailableLanguages = availableLanguages;
    }

    public boolean isByClass()
    {
        return ByClass;
    }

    public void setByClass(boolean byClass)
    {
        ByClass = byClass;
    }

    public CreatureType getCreatureCategory()
    {
        return CreatureCategory;
    }

    public void setCreatureCategory(CreatureType creatureCategory)
    {
        CreatureCategory = creatureCategory;
    }

    public int getMovementTypes()
    {
        return MovementTypes;
    }

    public void setMovementTypes(int movementTypes)
    {
        MovementTypes = movementTypes;
    }

    public int getSenses()
    {
        return Senses;
    }

    public void setSenses(int senses)
    {
        Senses = senses;
    }
    //endregion
}

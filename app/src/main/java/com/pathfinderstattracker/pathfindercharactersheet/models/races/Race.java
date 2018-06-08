package com.pathfinderstattracker.pathfindercharactersheet.models.races;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreChange;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */
import java.io.Serializable;

public class Race implements IRace, Serializable
{
    private int HitDiceSize;
    private List<BodySlotsEnum> AvailableEquipmentSlots;
    private List<IAbility> RacialAbilities;
    private List<ISkill> RacialSkills; //Need to replace with Skills[] when skills are created
    private SizeCategoryEnum Size;
    private List<AbilityScoreChange> StatChanges;
    private List<String> AvailableLanguages; //May need to make a language enum or class
    private boolean ByClass; //This is used to check if Skills and HitDiceSize are replaced by Class versions
    private CreatureType CreatureCategory;
    private List<IMovement> MovementTypes;
    private List<ISense> Senses;

    //region Getters and Setters
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

    public List<IAbility> getRacialAbilities()
    {
        return RacialAbilities;
    }

    public void setRacialAbilities(List<IAbility> racialAbilities)
    {
        RacialAbilities = racialAbilities;
    }

    public List<ISkill> getRacialSkills()
    {
        return RacialSkills;
    }

    public void setRacialSkills(List<ISkill> racialSkills)
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

    public List<IMovement> getMovementTypes()
    {
        return MovementTypes;
    }

    public void setMovementTypes(List<IMovement> movementTypes)
    {
        MovementTypes = movementTypes;
    }

    public List<ISense> getSenses()
    {
        return Senses;
    }

    public void setSenses(List<ISense> senses)
    {
        Senses = senses;
    }
    //endregion


    public Race()
    {
        //Default Constructor
    }

    public Race(int hitDiceSize, List<BodySlotsEnum> availableEquipmentSlots, List<IAbility> racialAbilities, List<ISkill> racialSkills, SizeCategoryEnum size, List<AbilityScoreChange> statChanges, List<String> availableLanguages, boolean byClass, CreatureType creatureCategory, List<IMovement> movementTypes, List<ISense> senses)
    {
        setHitDiceSize(hitDiceSize);
        setAvailableEquipmentSlots(availableEquipmentSlots);
        setRacialAbilities(racialAbilities);
        setRacialSkills(racialSkills);
        setSize(size);
        setStatChanges(statChanges);
        setAvailableLanguages(availableLanguages);
        setByClass(byClass);
        setCreatureCategory(creatureCategory);
        setMovementTypes(movementTypes);
        setSenses(senses);
    }
}

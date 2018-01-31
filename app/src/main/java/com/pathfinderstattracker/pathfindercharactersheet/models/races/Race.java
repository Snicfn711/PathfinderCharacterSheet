package com.pathfinderstattracker.pathfindercharactersheet.models.races;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreChange;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Race implements IRace
{
    public int HitDiceSize;
    public BodySlotsEnum[] AvailableEquipmentSlots;
    public Ability[] RacialAbilities;
    public String RacialsSkills; //Need to replace with Skills[] when skills are created
    public SizeCategoryEnum Size;
    public AbilityScoreChange[] StatChanges;
    public String[] AvailableLanguages; //May need to make a language enum or class
    public boolean ByClass; //This is used to check if Skills and HitDiceSize are replaced by Class versions
    public CreatureType CreatureCategory;
    public Movement[] MovementTypes;
    public Sense[] Senses;
}

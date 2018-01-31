package com.pathfinderstattracker.pathfindercharactersheet.models.races;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScoreChange;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IRace extends IMovement, ISense
{
    int HitDiceSize = 8;
    BodySlotsEnum[] AvailableEquipmentSlots = null;
    IAbility[] RacialAbilities = null;
    String RacialsSkills = null; //Need to replace with Skills[] when skills are created
    SizeCategoryEnum Size = SizeCategoryEnum.Medium;
    IAbilityScoreChange[] StatChanges = null;
    String[] AvailableLanguages = null;
    boolean ByClass = true; //This is used to check if Skills and HitDiceSize are replaced by Class versions
}

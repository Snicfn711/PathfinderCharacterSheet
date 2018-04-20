package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

@Entity
public class SkillWeaponEnchantmentJoinTableEntity
{
    @PrimaryKey
    @ColumnInfo(name = "weapon_enchantment_id")
    private int weaponEnchantmentID;
    @ColumnInfo(name ="checked_skill_id")
    private int checkedSkillID;
    @ColumnInfo(name ="additional_skill_id")
    private int additionalSkillID;
    @ColumnInfo(name ="skill_for_bonus_id")
    private int skillForBonusID;
}

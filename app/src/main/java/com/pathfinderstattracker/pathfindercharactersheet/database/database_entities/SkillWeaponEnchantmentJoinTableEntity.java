package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

@Entity(foreignKeys = {@ForeignKey(entity = WeaponEnchantmentEntity.class,
                                  parentColumns = "uid",
                                  childColumns = "weapon_enchantment_id"),
                       @ForeignKey(entity = SkillEntity.class,
                                  parentColumns = "uid",
                                  childColumns = "checked_skill_id"),
                       @ForeignKey(entity = SkillEntity.class,
                                  parentColumns = "uid",
                                  childColumns = "additional_skill_id"),
                       @ForeignKey(entity = SkillEntity.class,
                                  parentColumns = "uid",
                                  childColumns = "skill_for_bonus_id")})
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

    //region Getters and setters
    public int getWeaponEnchantmentID()
    {
        return weaponEnchantmentID;
    }

    public void setWeaponEnchantmentID(int weaponEnchantmentID)
    {
        this.weaponEnchantmentID = weaponEnchantmentID;
    }

    public int getCheckedSkillID()
    {
        return checkedSkillID;
    }

    public void setCheckedSkillID(int checkedSkillID)
    {
        this.checkedSkillID = checkedSkillID;
    }

    public int getAdditionalSkillID()
    {
        return additionalSkillID;
    }

    public void setAdditionalSkillID(int additionalSkillID)
    {
        this.additionalSkillID = additionalSkillID;
    }

    public int getSkillForBonusID()
    {
        return skillForBonusID;
    }

    public void setSkillForBonusID(int skillForBonusID)
    {
        this.skillForBonusID = skillForBonusID;
    }
    //endregion
}

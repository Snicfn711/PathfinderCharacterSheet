package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Weapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Dao
public interface WeaponEnchantmentDao
{
    @Insert
    public void insertWeaponEnchantment(IWeaponEnchantment enchantment);
    @Query("SELECT * FROM WeaponEnchantmentEntity " +
            "WHERE required_tags IN :weaponTagsToCheck " +
            "AND required_damage_type IN :weaponDamageTypesToCheck " +
            "AND required_weapon_name LIKE :requiredWeaponName " +
            "AND required_weight_class IN :weaponWeightClass " +
            "AND weapon_enchantmentID_being_restricted IN :currentlyAppliedEnchantments")
    List<WeaponEnchantment> getValidEnchantments(List<WeaponTagEnum> weaponTagsToCheck,
                                                 List<WeaponDamageTypeEnum> weaponDamagetTypesToCheck,
                                                 String requiredWeaponName,
                                                 WeaponWeightClassEnum weaponWeightClass,
                                                 List<IWeaponEnchantment> currentlyAppliedEnchantments);
}

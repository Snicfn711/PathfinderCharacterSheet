package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.WeaponEnchantmentEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponTagEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Dao

public interface WeaponEnchantmentDao
{
    @Insert
    public void insertWeaponEnchantment(WeaponEnchantmentEntity enchantment);
    @Query("SELECT * FROM weapon_enchantments " +
            "WHERE required_tags IN (:weaponTagsToCheck)")
    @TypeConverters(WeaponTagEnumConverter.class)
    List<WeaponEnchantmentEntity> getValidEnchantments(List<WeaponTagEnum> weaponTagsToCheck);
}
